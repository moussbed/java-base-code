package org.mb.base.threads;



public class PatternSingleton {


    /*
     Comme vous l'avez peut-être remarqué nous avons ajouté le modificateur
     volatile à notre object singleton. Ce mot clé empêche un cas subtil où le compilateur
     essaie d'optimiser le code de telle sorte que l'on accède à l'objet avant la fin
     de sa construction.
     Ce type de singleton est appelé Single avec verrouillage à double contrôle.
     */
    private static volatile PatternSingleton instance;

    private PatternSingleton() {
    }

    public static PatternSingleton getInstance(){

        if (instance == null) {
             synchronized (PatternSingleton.class){
                  if(instance==null) instance = new PatternSingleton();
             }
        }

        return instance;
    }

    public void display(){
        System.out.println(" Hello World !");
    }

}
