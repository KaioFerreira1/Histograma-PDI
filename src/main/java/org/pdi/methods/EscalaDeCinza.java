package org.pdi.methods;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EscalaDeCinza {
    public static void HistogramaCinza (){
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File("C:\\Users\\kaiof\\Downloads\\grey_scale.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //vetor para armazenar os valores do histograma
        int[] histograma = new int[256];

        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                //Obtem o valor de intensidade de pixel
                int pixel = imagem.getRGB(x, y) & 0xFF;

                histograma[pixel]++;
            }
        }

        //exibe o histograma
        for (int i = 0; i < histograma.length; i++) {
            if (histograma[i] > 0) {
                System.out.println("Cor(" + i + ", " + i + ", " + i + "): Intensidade: " + i + ", Frequência: " + histograma[i] + " vezes");
            }
        }
    }
}
