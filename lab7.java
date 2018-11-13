Color shadeColor(Color c, double factor) {
  int newRed = doubleToInt(factor*c.getRed());
  int newGreen = doubleToInt(factor*c.getGreen());
  int newBlue = doubleToInt(factor*c.getBlue());
  return new Color(newred, newGreen, newBlue);
}

Color[] shadePixels(Color[] originalPixels, double factor) {
  int size = originalpixels.length;
  Color[] newArray = new Color[size];
  for (int i = 0; i < size; i += 1) {
    newArray[i] = shadeColor(originalPixels[i], factor);
  }
  return newArray;
}

// factor should be value from 0 to 1
// the smaller the factor, the darker the shade
Image shade(Image original, double factor) {
  int width = original.getWidth();
  int height = original.getHeight();
  Color[] pixels = shadePixels(original.getPixels(), factor);
  return new Image(width, height, pixels);
}

String path = "image-files/cute_cat_and_dog_3.jpg";
Image catDog = readImage(path);
Image shadedCatDog = shade(catDog, 0.5);
