package ru.geekbrains;

public class Main {

    public static void main(String[] args) {

        CameraRoll roll1 = new ColorCameraRoll();
        CameraRoll roll2 = new BlackAndWhiteCameraRoll();
        Camera camera = new Camera(roll1);
        camera.doPhotography();
    }
}
