
public class BlurToDecay {

    public static void main(String[] args) {
        String fileName=args[0];
        int N=Integer.parseInt(args[1]);
        int [][][] picMatrix=ImageOps.read(fileName);
        for(int i=0;i<N;i++) {
            picMatrix=ImageOps.edges(picMatrix);
        }
        ImageOps.show(picMatrix);
    }

}
