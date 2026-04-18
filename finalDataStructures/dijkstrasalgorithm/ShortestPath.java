package dijkstrasalgorithm;

public class ShortestPath {

	public static void main(String[] args) {


		int a[][] = { 	{Integer.MAX_VALUE, 24, 5, 10, Integer.MAX_VALUE, Integer.MAX_VALUE},
				{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
				{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 30, 10},
				{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8},
				{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
				{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 20, Integer.MAX_VALUE} };
		Dijkstra(a, 0);
	}



	static void Dijkstra(int a[][], int startV) {

		if (startV < 0 || startV > a.length)
			throw new IllegalAccessError();

		int distance[] = new int[a.length];
		int visited[] = new int[a.length];
		int prev[] = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			distance[i] = Integer.MAX_VALUE;
			visited[i] = -1;
			prev[i] = -1;
		}

		distance[startV] = 0;

		for (int s = 0; s < a.length; s++) {
			// select
			int iMin = distance.length-1;

			for (int j = 0; j < distance.length; j++) {

				if (distance[j] <= distance[iMin] && visited[j] == -1) {
					iMin = j;
				}
			}

			for (int n = 0; n < a.length; n++) {
				if (a[iMin][n] != Integer.MAX_VALUE && visited[n] == -1 && distance[iMin] + a[iMin][n] < distance[n]) {
					distance[n] = distance[iMin] + a[iMin][n];
					prev[n] = iMin;
				}
			}




			visited[iMin] = 1;

		}

		for(int k = 0; k < a.length; k++) {
			System.out.println(distance[k]+" "+prev[k]+" "+visited[k]);

		}
	}


}



