package no.hvl.dat153.quizapp_oblig3;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "imageTable")
public class ImageEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private String imageDescription;

    private String imageUri; // Lagret som String i stedet for Uri

    public ImageEntity(@NonNull String imageDescription, @NonNull String imageUri) {
        this.imageDescription = imageDescription;
        this.imageUri = imageUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getImageDescription() {
        return imageDescription;
    }

    @NonNull
    public String getImageUri() {
        return imageUri;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "id=" + id +
                ", imageDescription='" + imageDescription + '\'' +
                ", imageUri='" + imageUri + '\'' +
                '}';
    }
}


