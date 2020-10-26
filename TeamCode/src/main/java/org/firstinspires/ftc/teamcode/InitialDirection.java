package org.firstinspires.ftc.teamcode;


public class InitialDirection {

    private static final DirectionEnum direction = DirectionEnum.WEST;

    public enum DirectionEnum{
        NORTH(90), SOUTH(-90), EAST(180), WEST(0);
        private double correction;
        private DirectionEnum(double correction) {
            this.correction = correction;
        }
        public double getCorrection() {

            return correction;
        }
    }

    public static DirectionEnum getInitDirection(){
        return direction;
    }
}