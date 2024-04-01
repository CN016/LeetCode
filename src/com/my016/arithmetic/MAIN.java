package com.my016.arithmetic;

public class MAIN {
    public static void main(String[] args) {
        //测试略
        POINT p = new POINT();
        System.out.println(p);
    }

    private static class POINT{

        @Override
        public String toString() {
            return "POINT{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        private  double x;
        private  double y;

        public POINT() {
        }

        public POINT(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    private static class CIRCLE{
        private POINT center;
        private float radius;

        public POINT getCenter() {
            return center;
        }

        public void setCenter(POINT center) {
            this.center = center;
        }

        public float getRadius() {
            return radius;
        }

        public void setRadius(float radius) {
            this.radius = radius;
        }

        public CIRCLE() {
        }

        public CIRCLE(POINT center, float radius) {
            this.center = center;
            this.radius = radius;
        }

        boolean P_IN_CIRCLE(POINT P){
            return distance_between_two_points(this.center, P) < this.radius;
        }

        /**
         * 判断两个圆的关系
         * @param C2 第二个圆
         * @return 0代表相切，1代表相交，-1代表相离，-2代表内含
         */
        public int Y_Y_GX(CIRCLE C2){
            if (distance_between_two_points(this.center,C2.getCenter()) > this.radius+C2.getRadius()){
                return -1;
            }
            if (distance_between_two_points(this.center,C2.getCenter()) == this.radius+ C2.getRadius()){
                return  0;
            }
            if (distance_between_two_points(this.center,C2.getCenter()) == this.radius- C2.getRadius()){
                return  0;
            }
            if (distance_between_two_points(this.center,C2.getCenter()) < this.radius+ C2.getRadius()){
                if (distance_between_two_points(this.center,C2.getCenter()) > this.radius- C2.getRadius()){
                    return  1;
                }
            }
            if (distance_between_two_points(this.center,C2.getCenter()) > this.radius- C2.getRadius()){
                return  -2;
            }
            return 0;
        }

        /**
         * 计算两点间的距离
         * @param _1 点1
         * @param _2 点2
         * @return 距离绝对值
         */
        private double  distance_between_two_points(POINT _1, POINT _2){
            double x1 = _1.getX();
            double x2 = _2.getX();
            double y1 = _1.getY();
            double y2 = _2.getY();

            double sq = (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
            return Math.sqrt(sq);
        }
    }
}
