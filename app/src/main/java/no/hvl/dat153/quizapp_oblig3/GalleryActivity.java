package no.hvl.dat153.quizapp_oblig3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageAdapter adapter;
    private ImageViewModel imageViewModel;

    private ActivityResultLauncher<Intent> pickImageLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        recyclerView = findViewById(R.id.recycler_view_gallery);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ImageAdapter(this);
        recyclerView.setAdapter(adapter);

        imageViewModel = new ViewModelProvider(this).get(ImageViewModel.class);

        pickImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            Uri selectedImageUri = intent.getData();
                            if (selectedImageUri != null) {
                                EditText editText = findViewById(R.id.textinput);
                                String imageText = editText.getText().toString();
                                ImageEntity imageEntity = new ImageEntity(imageText, selectedImageUri.toString());
                                imageViewModel.insert(imageEntity);
                                Toast.makeText(GalleryActivity.this, "Image added to gallery", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

        imageViewModel.getAllImages().observe(this, imageEntities -> {
            adapter.setImageList(imageEntities);
        });

        Button addButton = findViewById(R.id.addbutton);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            pickImageLauncher.launch(intent);
        });
    }
}








