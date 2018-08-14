package be.evoliris.formation.rpgandroid.factories;

import android.support.annotation.NonNull;

import be.evoliris.formation.rpgandroid.Constants;
import be.evoliris.formation.rpgandroid.models.Human;
import be.evoliris.formation.rpgandroid.models.Personnage;

public abstract class PersonnageFactory {
    public static Personnage createPersonnage(String name,@NonNull String classe){
        Personnage p;

        switch (classe){
            case "Elfe": p = createElf(name);break;
            case "Nain": p = createNain(name);break;
            case "Humain": p = createHuman(name);break;
            default: p = null; break;
        }

        return p;
    }

    private static Personnage createHuman(String name) {
        double force = Constants.Personnage.BASE_STRENGHT * Constants.Personnage.HUMAN_MODIFIER_STRENGHT;
        double endurance = Constants.Personnage.BASE_ENDURANCE * Constants.Personnage.HUMAN_MODIFIER_ENDURANCE;
        double hp = Constants.Personnage.BASE_HP * (endurance - 0.1 * force);

        return new Human(name, hp, force, endurance);

    }

    private static Personnage createNain(String name) {
        double force = Constants.Personnage.BASE_STRENGHT * Constants.Personnage.NAIN_MODIFIER_STRENGHT;
        double endurance = Constants.Personnage.BASE_ENDURANCE * Constants.Personnage.NAIN_MODIFIER_ENDURANCE;
        double hp = Constants.Personnage.BASE_HP * (endurance + 0.1 * force);

        return new Human(name, hp, force, endurance);

    }

    private static Personnage createElf(String name) {
        double force = Constants.Personnage.BASE_STRENGHT * Constants.Personnage.ELF_MODIFIER_STRENGHT;
        double endurance = Constants.Personnage.BASE_ENDURANCE * Constants.Personnage.ELF_MODIFIER_ENDURANCE;
        double hp = Constants.Personnage.BASE_HP * endurance;

        return new Human(name, hp, force, endurance);

    }
}
