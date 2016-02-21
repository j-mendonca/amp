package com.postage.justin.amp;


public class Amp {
    private int height;
    private int width;
    private int length;
    private int weight;

    public Amp(int length, int width, int height, int weight) throws OutOfRangeException {

        if(height < Constants.MIN_HEIGHT_STANDARD || height > Constants.MAX_HEIGHT_NONSTANDARD){
            throw new OutOfRangeException();
        } else {
            this.height = height;
        }

        if(width < Constants.MIN_WIDTH_STANDARD || width > Constants.MAX_WIDTH_NONSTANDARD){
            throw new OutOfRangeException();
        } else {
            this.width = width;
        }

        if(length < Constants.MIN_LENGTH_STANDARD || length > Constants.MAX_LENGTH_NONSTANDARD){
            throw new OutOfRangeException();
        } else {
            this.length = length;
        }

        if(weight < Constants.MIN_WEIGHT_STANDARD || weight > Constants.MAX_WEIGHT_NONSTANDARD){
            throw new OutOfRangeException();
        } else{
            this.weight = weight;
        }
    }

    public double calculate() throws OutOfRangeException{
        double result=0;

        if (this.length > Constants.MAX_LENGTH_STANDARD){
            result = calculateNonStandard();
        }

        else if(this.width > Constants.MAX_WIDTH_STANDARD){
            result = calculateNonStandard();
        }

        else if(this.weight > Constants.MAX_WEIGHT_STANDARD){
            result = calculateNonStandard();
        }

        else if(this.height > Constants.MAX_HEIGHT_STANDARD){
            result = calculateNonStandard();
        }

        //dealing with a standard package
        else if (this.weight <= Constants.STANDARD_LOW_WEIGHT){
            result = Constants.STANDARD_PRICE_LOW_WEIGHT;
        } else {
            result = Constants.STANDARD_PRICE_HIGH_WEIGHT;
        }

        return result;
    }

    private double calculateNonStandard(){

        double result =0;

        if(this.weight > Constants.NONSTANDARD_LOW_WEIGHT){
            result = Constants.NONSTANDARD_PRICE_HIGH_WEIGHT;
        } else {
            result = Constants.NONSTANDARD_PRICE_LOW_WEIGHT;
        }

        return result;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws OutOfRangeException {
        if(height < Constants.MIN_HEIGHT_STANDARD || height > Constants.MAX_HEIGHT_NONSTANDARD){
            throw new OutOfRangeException();
        } else {
            this.height = height;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws OutOfRangeException {
        if(width < Constants.MIN_WIDTH_STANDARD || width > Constants.MAX_WIDTH_NONSTANDARD){
            throw new OutOfRangeException();
        } else {
            this.width = width;
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) throws OutOfRangeException {
        if(length < Constants.MIN_LENGTH_STANDARD || length > Constants.MAX_LENGTH_NONSTANDARD){
            throw new OutOfRangeException();
        } else {
            this.length = length;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws OutOfRangeException {
        if(weight < Constants.MIN_WEIGHT_STANDARD || weight > Constants.MAX_WEIGHT_NONSTANDARD){
            throw new OutOfRangeException();
        } else{
            this.weight = weight;
        }
    }

}
