
public class BasicEditor {

    public static void main(String[] args) {
        if(args.length==1) {
            ImageOps.show(ImageOps.read(args[0]));
        }
        else if(args.length==2) {
            int [][][] picMatrix;
            picMatrix = ImageOps.read(args[0]);
            switch (args[1]) {
            case "fh":
                ImageOps.flipHorizontally(picMatrix);
                ImageOps.show(picMatrix);
                break;
            case "fv":
                ImageOps.flipVertically(picMatrix);
                ImageOps.show(picMatrix);
                break;
            case "gr":
                ImageOps.show(ImageOps.greyScaled(ImageOps.read(args[0])));
            break;

            }
        }
    }

}
