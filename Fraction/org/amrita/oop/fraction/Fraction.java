package org.amrita.oop.fraction;

public class Fraction {
 protected int numerator;
 protected int denominator;
 private static int count = 0;
 public int d = 0;

 public void setNumerator(int n) {
  this.numerator = n;
 }

 public float getValue(){
 	return (float) (numerator/denominator);
 }

 public void setDenominator(int d) throws ZeroDenominatorException{
 	if (d != 0)
 		denominator = d;
 	else
 		throw new ZeroDenominatorException("Denominator Cant be Zero");
 }
 public int getNumerator() {
  return numerator;
 }

 public int getDenominator() {
  return denominator;
 }

 Fraction() {
  this.numerator = 0;
  this.denominator = 1;
  incrementCount();
 }

 Fraction(int n, int d){
  this.numerator = n;
  this.denominator = d;
  incrementCount();
 }

 Fraction(int n) {
  this.numerator = n;
  this.denominator = 1;
  incrementCount();
 }

 public static void incrementCount() {
  count++;
 }

 public static void printCount() {
  System.out.println("count = " + count);
 }
 public Fraction inverse() {
  Fraction f = new Fraction(denominator, numerator);
  return f;
 }

 public Fraction reduce() {
  int min = (numerator < denominator) ? numerator : denominator;
  int i = 2;
  while (i <= min) {
   if (numerator % i == 0 && denominator % i == 0) {
    numerator /= i;
    denominator /= i;
   } else
    ++i;
  }
  Fraction f = new Fraction(numerator, denominator);
  return f;
 }

 public boolean isProper() {
  if (this.numerator < this.denominator)
   return true;
  else
   return false;
 }

 public void print() {
  System.out.print(this.numerator + "/" + this.denominator);
 }

 public Fraction computeInverse() {
  Fraction inv = new Fraction(this.denominator, this.numerator);
  return inv;
 }


 public MixedFraction toMixedFraction() {
 	MixedFraction f = new MixedFraction(0 , getNumerator() , getDenominator());
 	f.setWholeNum(getNumerator() / getDenominator());
 	f.setNumerator(getNumerator() % getDenominator());
 	return f;
 }

 /** This method adds two fractions and returns the sum */
 public Fraction add(Fraction second) {
   Fraction i = new Fraction(this.getNumerator() * second.getDenominator() + second.getNumerator() * this.getDenominator(), this.getDenominator() * second.getDenominator());
   return i;
 }

 /** This method subtracts two fractions and returns the difference */
 public Fraction subtract(Fraction second) {
   Fraction i = new Fraction(this.getNumerator() * second.getDenominator() - second.getNumerator() * this.getDenominator(), this.getDenominator() * second.getDenominator());
   return i;
 }

 public Fraction multiply(Fraction frac) {
  int n, d;
  n = this.numerator * frac.getNumerator();
  d = this.denominator * frac.getDenominator();
  Fraction i = new Fraction(n, d);
  i.reduce();
  return i;
 }
}
