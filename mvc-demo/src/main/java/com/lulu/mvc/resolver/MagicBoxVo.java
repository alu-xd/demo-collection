package com.lulu.mvc.resolver;

public class MagicBoxVo {
    private String randomNum;
    private String gift;
    private UnknownBox unknownBox;

    public String getRandomNum() {
        return randomNum;
    }

    public String getGift() {
        return gift;
    }

    public void setRandomNum(String randomNum) {
        this.randomNum = randomNum;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public void setUnknownBox(UnknownBox unknownBox) {
        this.unknownBox = unknownBox;
    }

    public UnknownBox getUnknownBox() {
        return unknownBox;
    }

    public static class UnknownBox{
        private String box;

        public UnknownBox(String box) {
            this.box = box;
        }

        public String getBox() {
            return box;
        }
    }
}
