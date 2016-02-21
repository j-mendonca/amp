package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import amp.Amp;
import amp.OutOfRangeException;
import utils.Constants;

public class TestAmp {
	
	Amp amp;
	int testLength;
	int testWidth;
	int testHeight;
	int testWeight;
		
	@Before
	public void setUp() throws OutOfRangeException{
		this.testLength = 150;
		this.testWidth = 100;
		this.testHeight = 3;
		this.testWeight = 20;
		amp = new Amp(this.testLength,this.testWidth,this.testHeight,this.testWeight); //standard size package
	}
	
	@Test
	public void testValidLength(){
		assertTrue(amp.getLength() > 0);
	}
	
	@Test
	public void testValidWidth(){
		assertTrue(amp.getWidth() > 0);
	}
	
	@Test
	public void testValidHeight(){
		assertTrue(amp.getHeight() > 0);
	}
	
	@Test
	public void testValidWeight(){
		assertTrue(amp.getWeight() > 0);
	}
	
	@Test
	public void testSetInvalidLengthBelowRange(){
		boolean errorOccured = false;
		try{
			amp.setLength(0);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testSetInvalidHeightBelowRange(){
		boolean errorOccured = false;
		try{
			amp.setHeight(0);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testSetInvalidWidthBelowRange(){
		boolean errorOccured = false;
		try{
			amp.setWidth(0);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testSetInvalidWeightBelowRange(){
		boolean errorOccured = false;
		try{
			amp.setWeight(0);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testCreateInvalidLengthBelowRange(){
		boolean errorOccured = false;
		try{
			Amp test = new Amp(0,testWidth,testHeight,testWeight);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testCreateInvalidHeightBelowRange(){
		boolean errorOccured = false;
		try{
			Amp test = new Amp(testLength,testWidth,0,testWeight);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testCreateInvalidWidthBelowRange(){
		boolean errorOccured = false;
		try{
			Amp test = new Amp(testLength,0,testHeight,testWeight);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testCreateInvalidWeightBelowRange(){
		boolean errorOccured = false;
		try{
			Amp test = new Amp(testLength,testWidth,testHeight,0);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testSetInvalidLengthAboveRange(){
		boolean errorOccured = false;
		try{
			amp.setLength(390);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testSetInvalidHeightAboveRange(){
		boolean errorOccured = false;
		try{
			amp.setHeight(30);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testSetInvalidWidthAboveRange(){
		boolean errorOccured = false;
		try{
			amp.setWidth(280);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testSetInvalidWeightAboveRange(){
		boolean errorOccured = false;
		try{
			amp.setWeight(600);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testCreateInvalidLengthAboveRange(){
		boolean errorOccured = false;
		try{
			Amp test = new Amp(390,testWidth,testHeight,testWeight);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testCreateInvalidHeightAboveRange(){
		boolean errorOccured = false;
		try{
			Amp test = new Amp(testLength,testWidth,30,testWeight);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testCreateInvalidWidthAboveRange(){
		boolean errorOccured = false;
		try{
			Amp test = new Amp(testLength,280,testHeight,testWeight);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testCreateInvalidWeightAboveRange(){
		boolean errorOccured = false;
		try{
			Amp test = new Amp(testLength,testWidth,testHeight,600);
		} catch (Exception e){
			errorOccured = true;
		}
		assertTrue(errorOccured);
	}
	
	@Test
	public void testGetLength(){
		int actualLength = amp.getLength();
		assertEquals(this.testLength, actualLength);
	}
	
	@Test
	public void testGetWidth(){
		int actualWidth = amp.getWidth();
		assertEquals(this.testWidth, actualWidth);
	}
	
	@Test
	public void testGetHeight(){
		int actualHeight = amp.getHeight();
		assertEquals(this.testHeight, actualHeight);
	}
	
	@Test
	public void testGetWeight(){
		int actualWeight = amp.getWeight();
		assertEquals(this.testWeight, actualWeight);
	}
	
	@Test
	public void testSetLength() throws OutOfRangeException{
		int newLength = 151;
		amp.setLength(newLength);
		assertEquals(amp.getLength(), newLength);
	}
	
	@Test
	public void testSetWidth() throws OutOfRangeException{
		int newWidth = 101;
		amp.setWidth(newWidth);
		assertEquals(amp.getWidth(), newWidth);
	}
	
	@Test
	public void testSetHeight() throws OutOfRangeException{
		int newHeight = 4;
		amp.setHeight(newHeight);
		assertEquals(amp.getHeight(), newHeight);
	}
	
	@Test
	public void testSetWeight() throws OutOfRangeException{
		int newWeight = 21;
		amp.setWeight(newWeight);
		assertEquals(amp.getWeight(), newWeight);
	}
	
	@Test
	public void testCalculateStandard() throws OutOfRangeException{
		//test the standard size package below 30g
		reset();
		double expectedPrice = Constants.STANDARD_PRICE_LOW_WEIGHT;
		double actualPrice = 0;
		actualPrice = amp.calculate();
		assertTrue(expectedPrice == actualPrice);
	}	
	
	@Test
	public void testCalculateStandardHeavier() throws OutOfRangeException{
		//test the standard size package above 30g
		reset();
		amp.setWeight(40);
		double expectedPrice = Constants.STANDARD_PRICE_HIGH_WEIGHT;
		double actualPrice = amp.calculate();
		assertTrue(expectedPrice == actualPrice);
	}	
	
	@Test
	public void testCalculateNonStandardLength() throws OutOfRangeException{
		//test the non-standard length size package below 100g 
		reset();
		amp.setLength(370); //non-standard range is 245-380
		
		double expectedPrice = Constants.NONSTANDARD_PRICE_LOW_WEIGHT;
		double actualPrice = amp.calculate();
		assertTrue(expectedPrice == actualPrice);
	}
	
	@Test
	public void testCalculateNonStandardLengthHeavier() throws OutOfRangeException{
		//test the non-standard length size package above 100g;
		reset();
		amp.setLength(370);
		amp.setWeight(200);
		double expectedPrice = Constants.NONSTANDARD_PRICE_HIGH_WEIGHT;
		double actualPrice = amp.calculate();
		assertTrue(expectedPrice == actualPrice);
	}
	
	@Test
	public void testCalculateNonStandardWidth() throws OutOfRangeException{
		//test the non-standard width package below 100g
		reset();
		amp.setWidth(180); //non-standard range is 156-270
		
		double expectedPrice = Constants.NONSTANDARD_PRICE_LOW_WEIGHT;
		double actualPrice = amp.calculate();
		assertTrue(expectedPrice == actualPrice);
	}
	
	@Test
	public void testCalculateNonStandardWidthHeavier() throws OutOfRangeException{
		//test the non-standard width package above 100g
		reset();
		amp.setWidth(180);
		amp.setWeight(200);
		
		double expectedPrice = Constants.NONSTANDARD_PRICE_HIGH_WEIGHT;
		double actualPrice = amp.calculate();
		assertTrue(expectedPrice == actualPrice);
	}
	
	@Test
	public void testCalculateNonStandardHeight() throws OutOfRangeException{
		//test the non-standard height below 100g
		reset();
		amp.setHeight(15); //non-standard height is from 5-20
		
		double expectedPrice = Constants.NONSTANDARD_PRICE_LOW_WEIGHT;
		double actualPrice = amp.calculate();
		assertTrue(expectedPrice == actualPrice);
	}
	
	@Test
	public void testCalculateNonStandardHeightHeavier() throws OutOfRangeException{
		//test the non-standard height package above 100g
		reset();
		amp.setHeight(15);
		amp.setWeight(200);
				
		double expectedPrice = Constants.NONSTANDARD_PRICE_HIGH_WEIGHT;
		double actualPrice = amp.calculate();
		assertTrue(expectedPrice == actualPrice);
	}
	
	@Test
	public void testCalculateNonStandardWeight() throws OutOfRangeException{
		//test the non-standard weight package above 100g
		reset();
		amp.setWeight(200);
		
		double expectedPrice = Constants.NONSTANDARD_PRICE_HIGH_WEIGHT;
		double actualPrice = amp.calculate();
		assertTrue(expectedPrice == actualPrice);
	}

	private void reset() throws OutOfRangeException{
		this.amp.setHeight(this.testHeight);
		this.amp.setLength(this.testLength);
		this.amp.setWeight(this.testWeight);
		this.amp.setWidth(this.testWidth);
	}
	
}
