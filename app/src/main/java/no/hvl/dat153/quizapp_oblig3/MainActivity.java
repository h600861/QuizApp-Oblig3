package no.hvl.dat153.quizapp_oblig3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ImageViewModel imageViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewModel = new ViewModelProvider(this).get(ImageViewModel.class);
        //imageViewModel.deleteAllImages();

        // Legg til standardbilder hvis databasen er tom
        imageViewModel.getAllImages().observe(this, imageEntities -> {
            if (imageEntities.isEmpty()) {
                imageViewModel.insert(new ImageEntity("Beer", "android.resource://" + getPackageName() + "/" + R.drawable.beer_image));
                imageViewModel.insert(new ImageEntity("Sheep", "android.resource://" + getPackageName() + "/" + R.drawable.sheep_image));
                imageViewModel.insert(new ImageEntity("Tree", "android.resource://" + getPackageName() + "/" + R.drawable.tree_image));
            }
        });

        Button galleryButton = findViewById(R.id.gallery_button);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGalleryActivity();
            }
        });

        Button quizButton = findViewById(R.id.quiz_button);
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizActivity();
            }
        });
    }

    private void openGalleryActivity() {
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    private void openQuizActivity() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}

