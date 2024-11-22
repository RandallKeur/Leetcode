package com.leetcode.solutions.classes;

class ParkingSystem {

    private int bigSpots;
    private int mediumSpots;
    private int smallSpots;

    public ParkingSystem(int big, int medium, int small) {
        this.bigSpots = big;
        this.mediumSpots = medium;
        this.smallSpots = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1 && bigSpots > 0) {
            bigSpots--;
            return true;
        } else if (carType == 2 && mediumSpots > 0) {
            mediumSpots--;
            return true;
        } else if (carType == 3 && smallSpots > 0) {
            smallSpots--;
            return true;
        } else return false;
    }
}
