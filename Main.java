package one;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
		a.toString();
	}
}
class Fraction {
	int a;
	int b;
	Fraction(int a, int b){
		int m = Math.min(a, b);
		for(int i = 1; i <= m; i++) {
			if (a % m == 0 && b % m == 0) {
				a /= m;
				b /= m;
			}
		}
		this.a = a;
		this.b = b;
	}
	public void print() {
		if (this.a == this.b) {
			System.out.println(1);
		}
		else
		System.out.println(a + "/" + b);
	}
	public Fraction plus(Fraction exp) {
		int a1 = this.a * exp.b;
		int temp_b = this.b * exp.b;
		int a2 = exp.a * this.b;
		a1 += a2;
		int j = Math.min(a1, temp_b);
		for (int i = 1; i <= j; i++) {
			if (a1 % i == 0 && temp_b % i == 0) {
				a1 /= i;
				temp_b /= i;
			}
		}
		return new Fraction(a1, temp_b);
	}
	public Fraction multiply(Fraction exp) {
		int tempa = exp.a * this.a;
		int tempb = exp.b * this.b;
		return new Fraction(tempa,tempb);
	}
}