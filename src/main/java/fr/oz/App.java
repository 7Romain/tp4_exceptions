package fr.oz;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String nomClasse = JOptionPane.showInputDialog(null, "Nom de la classe (avec package) : ");
        try {
            Class maClasse = Class.forName(nomClasse);
            Object instance = maClasse.newInstance();
            JOptionPane.showMessageDialog(null, "Vous avez créé une instance à partir de la création dynamique"
                    + " d'une classe de type : " + instance.getClass().getName());

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "La classe " + nomClasse + " n'existe pas");
        } catch (InstantiationException ie) {
            JOptionPane.showMessageDialog(null, "L'instance de  " + nomClasse
                    + " n'a pas pu être créée. La classe ou le constructeur est inaccessible : " + ie.getMessage());

        } catch (IllegalAccessException iae) {
            JOptionPane.showMessageDialog(null, "L'instance de  " + nomClasse
                    + " n'a pas pu être créée. La classe ou le constructeur est inaccessible : " + iae.getMessage());
        } finally {
            int reply = JOptionPane.showConfirmDialog(null, "Voulez-vous instancier une autre classe?", "Fin ?",
                    JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                String nomClasse2 = JOptionPane.showInputDialog(null, "Nom de la classe (avec package) : ");

                try {
                    Class maClasse2 = Class.forName(nomClasse2);
                    Object instance2 = maClasse2.newInstance();
                    JOptionPane.showMessageDialog(null, "Vous avez créé une instance à partir de la création dynamique"
                            + " d'une classe de type : " + instance2.getClass().getName());

                } catch (ClassNotFoundException cnfe) {
                    JOptionPane.showMessageDialog(null, "La classe " + nomClasse2 + " n'existe pas");
                } catch (InstantiationException ie) {
                    JOptionPane.showMessageDialog(null, "L'instance de  " + nomClasse2
                            + " n'a pas pu être créée. La classe ou le constructeur est inaccessible : "
                            + ie.getMessage());

                } catch (IllegalAccessException iae) {
                    JOptionPane.showMessageDialog(null, "L'instance de  " + nomClasse2
                            + " n'a pas pu être créée. La classe ou le constructeur est inaccessible : "
                            + iae.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "Au Revoir");

            }

        }

    }
}
