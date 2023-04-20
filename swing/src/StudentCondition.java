public enum StudentCondition {
    DOING{
        @Override public String toString() {
            return "DOING";
        }
    },
    SICK{
        @Override public String toString() {
            return "SICK";
        }
    },
    ABSENT{
        @Override public String toString() {
            return "ABSENT";
        }
    }
}
