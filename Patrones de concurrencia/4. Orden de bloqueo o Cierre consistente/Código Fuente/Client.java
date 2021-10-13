public class Client {
    
	public static void main(String[] args) {
		
		FileSysUtil_Rev fsUtil = new FileSysUtil_Rev();
		Directory dir1 = new Directory("PC1");
		Directory dir2 = new Directory("PC2");
		Request req = new Request(dir1, dir2, fsUtil);
		Request req2 = new Request(dir2, dir1, fsUtil);
		Request req3 = new Request(dir2, dir1, fsUtil);
		Request req4 = new Request(dir1, dir2, fsUtil);
		Request req5 = new Request(dir1, dir2, fsUtil);
		Request req6 = new Request(dir2, dir1, fsUtil);
		
	}
}
