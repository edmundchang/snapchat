package snapchat;

import java.util.ArrayList;
import java.util.List;

public class BloomFilter {

	int n;
	int indexOfArrays = 0;
	List<boolean[]> bitsValues;

	List<HashFunction> hashFunctions;

	public boolean shouldExpand() {
		return true;
	}

	public BloomFilter(int n, List<HashFunction> hashFunctions) {
		this.n = n;
		bitsValues = new ArrayList<boolean[]>();
		boolean[] firstRow = new boolean[n];
		bitsValues.add(firstRow);
		this.hashFunctions = hashFunctions;
	}

	public void add(String input) {
		if (shouldExpand()) {
			indexOfArrays++;
			bitsValues.add(new boolean[n]);
		}
		for (HashFunction h : hashFunctions) {
			bitsValues.get(indexOfArrays)[h.hash(input, n)] = true;
		}
	}

	public boolean contains(String input) {
		boolean found = false;

		for (int i = 0; i < indexOfArrays; i++) {
			boolean foundInHere = true;
			for (HashFunction h : hashFunctions) {
				if (!bitsValues.get(i)[h.hash(input, n)]) {
					foundInHere = false;
					break;
				}
			}
			if (foundInHere) {
				found = true;
				break;
			}
		}

		return found;
	}

}
