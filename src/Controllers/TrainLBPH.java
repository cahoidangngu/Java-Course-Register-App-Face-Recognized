/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.IMREAD_GRAYSCALE;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.MatVector;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.FaceRecognizer;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.opencv.core.CvType;

/**
 *
 * @author quant
 */
public class TrainLBPH {
    public static void trainLBPH() {
        try {
            File directory = new File("photos\\");
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".jpg") || name.endsWith(".png");
                }
            };

            File[] files = directory.listFiles(filter);
            MatVector photos = new MatVector(files.length);
            Mat labels = new Mat(files.length, 1, CvType.CV_32SC1);
            IntBuffer labelBuffer = labels.createBuffer();

            int counnter = 0;
            for (File image : files) {
                Mat photo = imread(image.getAbsolutePath(), IMREAD_GRAYSCALE);
                int idPerson = Integer.parseInt(image.getName().split("\\.")[1]);
                opencv_imgproc.resize(photo, photo, new Size(160, 160));

                photos.put(counnter, photo);
                labelBuffer.put(counnter, idPerson);
                counnter++;
            }

            FaceRecognizer lbph = LBPHFaceRecognizer.create();
            lbph.train(photos, labels);
            lbph.save("photos\\classifierLBPH.yml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
