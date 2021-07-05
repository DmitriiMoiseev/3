package ru.geekbrains;

public class Camera {

    private final CameraRoll cameraRoll;

    public Camera(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    void doPhotography() {
        cameraRoll.processing();
    }

}
