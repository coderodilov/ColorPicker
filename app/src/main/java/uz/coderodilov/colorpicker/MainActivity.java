package uz.coderodilov.colorpicker;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import uz.coderodilov.colorpicker.databinding.ActivityMainBinding;
import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int initialColor = Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btnSetColor.setOnClickListener(v -> colorPickerDialog());
        }

    private void colorPickerDialog() {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(
                MainActivity.this, initialColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                // color is the color selected by the user.
                binding.tvText.setTextColor(color);
                initialColor = color;
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // cancel was selected by the user
            }
        });
        dialog.show();
    }
}