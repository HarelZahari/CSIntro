/**
 * A library of image editing functions.
 */
public class ImageOps {
    // Use these constants, as needed.
    static final int NUM_OF_COLORS = 3;
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    static final int MAX_COLOR_VALUE = 255;

    /**
     * Reads an image in PPM format from the given filename.
     * 
     * @param fileName
     *            - name of the given PPM file
     * @return - the image, as a 3-dimensional array
     */
    public static void main(String[] args) {
        //showData(read(args[0]));
        //flipHorizontally(read(args[0]));
        //flipVertically(read(args[0]));
        //greyScaled(read(args[0]));
        //show(blurred(read(args[0])));
        //int [][] tmp=horizontalGradient(read(args[0]));
        show(edges(read(args[0])));
    }
    
    public static int[][][] read(String filename) {
        StdIn.setInput(filename);
        if (StdIn.readLine().equals("P3")) {
            int column = StdIn.readInt();
            int row = StdIn.readInt();
            StdIn.readInt();
            int[][][] imgPPMMatrix = new int[row][column][3];
            while (!StdIn.isEmpty()) {
                for (int r = 0; r < row; r++) {
                    for (int c = 0; c < column; c++) {
                        for (int i = 0; i < NUM_OF_COLORS; i++) {
                            imgPPMMatrix[r][c][i] = StdIn.readInt();
                        }
                    }
                }
            }
            return imgPPMMatrix;
        } else
            return null;
    }

    /**
     * Prints the array values, nicely formatted.
     * 
     * @param pic
     *            - the image to display.
     */
    public static void showData(int[][][] pic) {
        System.out.println();
        for(int r=0;r<pic.length;r++) {
            for(int c=0;c<pic[r].length;c++) {
                for(int i=0;i<NUM_OF_COLORS;i++) {
                    System.out.print(pic[r][c][i]+" ");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
        
    }

    /**
     * Renders an image, using StdDraw.
     * 
     * @param pic
     *            - the image to render.
     */
    public static void show(int[][][] pic) {
        StdDraw.setCanvasSize(pic[0].length, pic.length);
        int height = pic.length;
        int width = pic[0].length;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.show(30);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                StdDraw.setPenColor(pic[i][j][R], pic[i][j][G], pic[i][j][B]);
                StdDraw.filledRectangle(j + 0.5, height - i - 0.5, 0.5, 0.5);
            }
        }
        StdDraw.show();
    }

    /**
     * Flips an image horizontally. SIDE EFFECT: Changes the given image.
     * 
     * @param pic
     *            - the image to flip
     */
    public static void flipHorizontally(int[][][] pic) {
        for (int r = 0; r < pic.length; r++) {
            for (int c = 0; c < pic[r].length / 2; c++) {
                swap(pic, r, c, r, (pic.length-1) - c);
            }
        }
        showData(pic);
    }

    /**
     * Flips an image vertically * SIDE EFFECT: Changes the given image.
     * 
     * @param pic
     *            - the image to flip
     */
    public static void flipVertically(int[][][] pic) {
        for (int c = 0; c < pic[0].length; c++) {
            for (int r = 0; r < pic.length/2; r++) {
                swap(pic, r, c, (pic.length-1)-r, c);
            }
        }
        //showData(pic);
    }

    // Swaps the two given pixels in the given image.
    // SIDE EFFECT: Changes the pixles in the given image.
    // i1,j1 - coordinates of the first pixel
    // i2,j2 - coordinates of the second pixel
    private static void swap(int[][][] pic, int i1, int j1, int i2, int j2) {
        int [] tmpPxl=new int [3];
        for(int i=0;i<NUM_OF_COLORS;i++) {
            tmpPxl[i]=pic[i1][j1][i];
        }
        for(int i=0;i<NUM_OF_COLORS;i++) {
            pic[i1][j1][i]=pic[i2][j2][i];
        }
        for(int i=0;i<NUM_OF_COLORS;i++) {
            pic[i2][j2][i]=tmpPxl[i];
        }
        
    }

    /**
     * Turns an RGB color into a greycale value, using a luminance formula. The
     * luminance is a weighted mean of the color's value, and is given by: 0.299 * r
     * + 0.587 * b + 0.114 * b.
     * 
     * @param color
     *            - the color to be greyScaled.
     * @return the greyscale value, as an array {greyscale, greyscale, greyscale}
     */
    public static int[] luminance(int[] color) {
        int lumCombination=(int)(0.299 * color[0] + 0.587 * color[1] + 0.114 * color[2]);
        int [] lumArr={lumCombination,lumCombination,lumCombination};
        return lumArr;
    }

    /**
     * Creates a greyscaled version of an image.
     * 
     * @param pic
     *            - the given image
     * @return - the greyscaled version of the image
     */
    public static int[][][] greyScaled(int[][][] pic) {
        int row = pic.length;
        int column = pic[0].length;
        int [][][] greyPic=new int [row][column][3];
        for(int r=0;r<pic.length;r++) {
            for(int c=0;c<pic[r].length;c++) {
                greyPic[r][c]=luminance(pic[r][c]);
            }
        }
        //showData(greyPic);
        return greyPic;
    }

    /**
     * Creates a blurred version of an image. Uses a block blur algorithm.
     * 
     * @param pic
     *            - the given image
     * @return - the blurred version of the image
     */
    public static int[][][] blurred(int[][][] pic) {
        int[][][] blurredPic = new int[pic.length + 2][pic[0].length + 2][NUM_OF_COLORS];
        for (int r = 0; r < blurredPic.length; r++) {
            for (int c = 0; c < blurredPic[r].length; c++) {
                if (r < pic.length && c < pic[r].length) {
                    for (int i = 0; i < NUM_OF_COLORS; i++) {
                        blurredPic[r][c][i] = pic[r][c][i];
                    }
                } else {
                    for (int i = 0; i < NUM_OF_COLORS; i++) {
                        blurredPic[r][c][i] = 0;
                    }
                }
            }
        }
        for (int r = 1; r < blurredPic.length-1; r++) {
            for (int c = 1; c < blurredPic[r].length-1; c++) {
                    for (int i = 0; i < NUM_OF_COLORS; i++) {
                        blurColor(pic, blurredPic, r, c, i);
                    }
            }
        }
        return blurredPic;
    }

    // Blurs a given color of a given pixel in a given image.
    // Stores the result in a blurred version of the given image, without effecting
    // the given image.
    // Uses a block blur algorithm.
    // pic - the given image
    // blurredPic - the blurred version of the given image
    // row - the row of the pixel
    // col - the column of the pixel
    // color - the color to blur: 0-red, 1-green, 2-blue
    private static void blurColor(int[][][] pic, int[][][] blurredPic, int row, int col, int color) {
        blurredPic[row+1][col+1][color]=getColorIntensity(blurredPic, row, col, color);
    }

    // Returns the color intensity of a pixel, or -1 if the coordinates of the pixel
    // are illegal.
    // pic - the given source image
    // row - the given row of the pixel
    // col - the given column of the pixel
    // color - the given color: 0-red, 1-green, 2-blue
    private static int getColorIntensity(int[][][] pic, int row, int col, int color) {
        int colorIntensity = 0;
        colorIntensity+=pic[row-1][col][color];
        colorIntensity+=pic[row-1][col-1][color];
        colorIntensity+=pic[row-1][col+1][color];
        colorIntensity+=pic[row][col+1][color];
        colorIntensity+=pic[row][col-1][color];
        colorIntensity+=pic[row+1][col][color];
        colorIntensity+=pic[row+1][col+1][color];
        colorIntensity+=pic[row+1][col-1][color];
        return (int)(colorIntensity/9);
    }

    /**
     * Calculates the horizontal gradient of the greyscaled version of an image
     * 
     * @param pic
     *            - the given image
     * @return - the gradient of the greyscaled version of the given image.
     */
    public static int[][] horizontalGradient(int[][][] pic) {
        int [][][] grayPicMatrix=greyScaled(pic);
        int [][] gradientGreyScaled=new int [pic.length][pic[0].length];
        for(int c=0;c<pic[0].length;c++) {
            for(int r=0;r<pic.length;r++) {
                if(c==0 || c==pic[0].length-1) {
                    gradientGreyScaled[r][c]=0;
                }
                else {
                    gradientGreyScaled[r][c]=grayPicMatrix[r][c+1][0]-grayPicMatrix[r][c-1][0];
                }
            }
        }
        //showData(grayPicMatrix);
        return gradientGreyScaled;
    }

    /**
     * Normalizes a 2D array so that all the values are between 0 to 255 SIDE
     * EFFECT: Changes the given array
     * 
     * @param arr
     *            - the given array
     */
    public static void normalize(int[][] arr) {
        int max=arr[0][0];
        int min=arr[0][0];
        for(int r=0;r<arr.length;r++) {
            for(int c=0;c<arr[0].length;c++) {
                if(max<arr[r][c]) {
                    max=arr[r][c];
                }
                if(min>arr[r][c]) {
                    min=arr[r][c];
                }
            }
        }
        for(int r=0;r<arr.length;r++) {
            for(int c=0;c<arr[0].length;c++) {
                arr[r][c]=(arr[r][c]-min)*max/(max-min);
            }
        }
    }

    /**
     * Creates a greyscaled image showing the horizontal edges of a given image.
     * Uses gradient edge detection.
     * 
     * @param pic
     *            - the given image
     * @return - a greyscaled image showing the horizontal edges of the given image
     */
    public static int[][][] edges(int[][][] pic) {
        int [][][] greyScaledPic=new int [pic.length][pic[0].length][3];
        int [][] GreyScaledMatrix=new int [pic.length][pic[0].length];
        GreyScaledMatrix=horizontalGradient(pic);
        normalize(GreyScaledMatrix);
        for(int r=0;r<pic.length;r++) {
            for(int c=0;c<pic[0].length;c++) {
                for(int i=0;i<NUM_OF_COLORS;i++) {
                    greyScaledPic[r][c][i]=GreyScaledMatrix[r][c];
                }
            }
        }
        return greyScaledPic;
    }
}
