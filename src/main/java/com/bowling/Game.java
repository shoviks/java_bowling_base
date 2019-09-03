package com.bowling;

public class Game {

    private int[] rolls;
    private int currentRoll;


    public Game() {
        rolls = new int[21];
        currentRoll = 0;
    }


    public void roll(int pins) {
        if (pins >= 0) {
            rolls[currentRoll++] = pins;
        } else {
            throw new IllegalArgumentException("Only positive number of pins can be knocked down");
        }
    }

    public int score() {
        int totalScore = 0;
        int rollNum = 0;

        for (int i = 0; i < 10; i++) {
            if (isStrike(rollNum)) {
                totalScore += 10 + getStrikeBonus(rollNum);
                rollNum++;
            } else if (isSpare(rollNum)) {
                totalScore += 10 + getSpareBonus(rollNum);
                rollNum += 2;
            } else {
                totalScore += getNumOfKnockedPinsForFrame(rollNum);
                rollNum += 2;
            }
        }

        return totalScore;

    }

    public int getNumOfKnockedPinsForFrame(int rollNum) {

        return rolls[rollNum] + rolls[rollNum + 1];
    }

    public boolean isSpare(int rollNum) {
        return rolls[rollNum] + rolls[rollNum + 1] == 10;
    }

    public boolean isStrike(int rollNum) {
        return rolls[rollNum] == 10;
    }

    public int getSpareBonus(int rollNum) {
        return rolls[rollNum + 2];
    }

    public int getStrikeBonus(int rollNum) {
        return rolls[rollNum + 1] + rolls[rollNum + 2];
    }

}

