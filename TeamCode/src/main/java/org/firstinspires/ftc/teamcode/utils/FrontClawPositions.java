package org.firstinspires.ftc.teamcode.utils;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Claw Position Finder", group = "TeleOp")
public class FrontClawPositions extends LinearOpMode {
    private Servo claw;

    @Override
    public void runOpMode() {
        claw = hardwareMap.get(Servo.class, "claw");
        double position = 0.45;
        double increment = 0.03;
        claw.setPosition(0.05);

        waitForStart();

        while (opModeIsActive()) {
            // sweep
            claw.setPosition(position);

            telemetry.addData("Position", position);
            telemetry.update();
            sleep(3000);

            position += increment;

            if (position > 1.0) {
                break;
            }
        }
        claw.setPosition(0.5);

        telemetry.addData("Status", "Calibration Complete");
        telemetry.update();
        sleep(2000);
    }
}