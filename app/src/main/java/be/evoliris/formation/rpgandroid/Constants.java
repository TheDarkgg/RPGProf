package be.evoliris.formation.rpgandroid;

public abstract class Constants {
    public static class Intent{
        public static final String CHARACTER_EXTRA = "CHARACTER";
        public static final String NAME_EXTRA = "NAME";
    }
    public static class Personnage{
        public static final double ELF_MODIFIER_STRENGHT = 0.8;
        public static final double ELF_MODIFIER_ENDURANCE = 1.4;

        public static final double NAIN_MODIFIER_STRENGHT = 1.2;
        public static final double NAIN_MODIFIER_ENDURANCE = 1;

        public static final double HUMAN_MODIFIER_STRENGHT = 1;
        public static final double HUMAN_MODIFIER_ENDURANCE = 1;

        public static final double TROLL_MODIFIER_STRENGHT = 1.4;
        public static final double TROLL_MODIFIER_ENDURANCE = 1.4;

        public static final double GNOME_MODIFIER_STRENGHT = 0.6;
        public static final double GNOME_MODIFIER_ENDURANCE = 0.6;

        public static final double BASE_STRENGHT = 10;
        public static final double BASE_ENDURANCE = 20;
        public static final double BASE_HP = 50;
    }
}
