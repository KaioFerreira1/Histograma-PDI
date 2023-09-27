package org.pdi.methods;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Colorida {
    public static void HistogramaColorido() {
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File("C:\\Users\\kaiof\\Downloads\\sombrinhas.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Vetor para armazenar os valores do histograma
        int[] histogramaRed = new int[256];
        int[] histogramaGreen = new int[256];
        int[] histogramaBlue = new int[256];

        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                // Obtenha o valor RGB do pixel
                int pixel = imagem.getRGB(x, y);
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;

                histogramaRed[red]++;
                histogramaGreen[green]++;
                histogramaBlue[blue]++;
            }
        }

        // Exibição do histograma
        for (int i = 0; i < 256; i++) {
            System.out.println("Cor vermelha " + i + ": " + histogramaRed[i] + " vezes");
            System.out.println("Cor verde " + i + ": " + histogramaGreen[i] + " vezes");
            System.out.println("Cor azul " + i + ": " + histogramaBlue[i] + " vezes");
        }
    }
}
