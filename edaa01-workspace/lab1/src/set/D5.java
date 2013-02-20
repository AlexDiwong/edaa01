package set;

import java.util.Arrays;
import java.util.Random;

public class D5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] k = {1,2,3,4,5,6,7,8,9,10,1,7,4,5};

		int[] l = uniqueElements(k);
		for (int i = 0; i < l.length; i++) {
			System.out.println(l[i]);
		}

	}

	public static int[] uniqueElements(int[] ints) {
		MaxSet<Integer> lista = new MaxSet<Integer>();
		for (int i = 0; i < ints.length; i++) {

			lista.add(ints[i]);
		}
		int[] ordnad = new int[lista.size()];
		int k = lista.size();
		int j = 1;
		while (lista.size() > 0) {
			ordnad[k - j] = lista.getMax();
			lista.remove(lista.getMax());
			j++;
		}
		return ordnad;
	}

}
