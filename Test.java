import java.io.File;

public class Test {
		public static void main(String[] args) {
				long avg = 0;
				Data data = new Data();
				data.get_csv_data(new File("/home/joon/Downloads/VNA_171101_161321.csv"));
				int[] freq = data.getFreq();
				float[] phase = data.getPhase();

				long elapsed_acc = 0;
				for (int j = 0; j < 1000; j++) {
						float min = phase[1];
						int index = 1;
						long start = System.nanoTime();
						for (int i = 2; i < 1569; i++) {
								if (phase[i] < min) {
										min = phase[i];
										index = i;
								}
						}
						long stop = System.nanoTime();
						long elapsed = stop - start;
						//System.out.println("Phase dip of " + min + " at Frequency " + freq[index]);
						//System.out.println("elapsed: " + elapsed + " ns");
						elapsed_acc += elapsed;
				}
				avg = elapsed_acc / 1000;
				System.out.println("AVG elpased: " + avg + " ns");
		}
}
