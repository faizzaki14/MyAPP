//package com.faizzakiramadhan_19104075.myapplication.ui.Profile;
//
//import android.content.ContentResolver;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Handler;
//import android.text.TextUtils;
//import android.view.View;
//import android.webkit.MimeTypeMap;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.faizzakiramadhan_19104075.myapplication.Fragment1;
//import com.faizzakiramadhan_19104075.myapplication.R;
//import com.google.android.gms.tasks.Continuation;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.UploadTask;
//import com.squareup.picasso.Picasso;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class profilefrg extends AppCompatActivity {
//
//    EditText nama_profile, desc_profile, nama_lengkap, nama_panggilan, alamat_profile, alamat_email, sosmed_ig;
//    Button button;
//    ImageView imageView;
//    ProgressBar progressBar;
//    Uri imageUri;
//    UploadTask uploadTask;
//    StorageReference storageReference;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference databaseReference;
//    FirebaseFirestore db = FirebaseFirestore.getInstance();
//    DocumentReference documentReference;
//
//    private static final int PICK_IMAGE =1;
//    All_UserMember member;
//    String currentUserId;
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_profile);
//
//        member = new All_UserMember();
//        imageView = findViewById(R.id.image_view);
//        nama_lengkap = findViewById(R.id.nama_lengkap);
//        desc_profile = findViewById(R.id.desc_profile);
//        nama_profile = findViewById(R.id.nama_profile);
//        nama_panggilan = findViewById(R.id.nama_panggilan);
//        alamat_profile = findViewById(R.id.alamat_profile);
//        alamat_email = findViewById(R.id.alamat_email);
//        sosmed_ig = findViewById(R.id.sosmed_ig);
//
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        currentUserId = user.getUid();
//
//        documentReference = db.collection("user").document(currentUserId);
//        storageReference = FirebaseStorage.getInstance().getReference("Profile images");
//        databaseReference = database.getReference("All User");
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                uploadData();
//            }
//        });
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent, PICK_IMAGE);
//            }
//        });
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        try {
//            if(requestCode == PICK_IMAGE || resultCode == RESULT_OK ||
//                    data != null || data.getData() != null){
//                imageUri = data.getData();
//
//                Picasso.get().load(imageUri).into(imageView);
//            }
//        }catch (Exception e){
//            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    private String getFiletxt(Uri uri){
//        ContentResolver contentResolver = getContentResolver();
//        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
//        return mimeTypeMap.getExtensionFromMimeType((contentResolver.getType(uri)));
//    }
//
//    private void uploadData() {
//
//        String nameprofile = nama_profile.getText().toString();
//        String descprofile = desc_profile.getText().toString();
//        String namalengkap = nama_lengkap.getText().toString();
//        String namapanggilan = nama_panggilan.getText().toString();
//        String alamat = alamat_profile.getText().toString();
//        String alamatemail = alamat_email.getText().toString();
//        String sosmedig = sosmed_ig.getText().toString();
//
//        if (!TextUtils.isEmpty(nameprofile) || !TextUtils.isEmpty(descprofile) || !TextUtils.isEmpty(namalengkap) || !TextUtils.isEmpty(namapanggilan) || !TextUtils.isEmpty(alamat) || !TextUtils.isEmpty(alamatemail) || !TextUtils.isEmpty(sosmedig) || imageUri != null ){
//
//            progressBar.setVisibility(View.VISIBLE);
//            final StorageReference reference = storageReference.child(System.currentTimeMillis()+ "." +getFiletxt(imageUri));
//            uploadTask = reference.putFile(imageUri);
//
//            Task<Uri> urlTask = uploadTask.continueWithTask(new  Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
//                @Override
//                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
//                    if(!task.isSuccessful()){
//                        throw  task.getException();
//                    }
//
//
//                    return reference.getDownloadUrl();
//                }
//            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
//                @Override
//                public void onComplete(@NonNull Task<Uri> task) {
//
//                    if (task.isSuccessful()){
//                        Uri downloadUri = task.getResult();
//
//                        Map<String,String> profile = new HashMap<>();
//                        profile.put("namaProfile", nameprofile);
//                        profile.put("desProfile", descprofile);
//                        profile.put("namalengkap", namalengkap);
//                        profile.put("namapanggilan", namapanggilan);
//                        profile.put("alamat", alamat);
//                        profile.put("alamatemail", alamatemail);
//                        profile.put("sosmedig", sosmedig);
//                        profile.put("privacy", "Public");
//
//                        member.setNameprofile(nameprofile);
//                        member.setDescprofile(descprofile);
//                        member.setNamalengkap(namalengkap);
//                        member.setNamapanggilan(namapanggilan);
//                        member.setAlamat(alamat);
//                        member.setAlamatemail(alamatemail);
//                        member.setSosmedig(sosmedig);
//                        member.setUrl(downloadUri.toString());
//
//                        databaseReference.child(currentUserId).setValue(member);
//
//                        documentReference.set(profile)
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//
//
//                                progressBar.setVisibility(View.INVISIBLE);
//                                Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Intent intent = new Intent(profilefrg.this, Fragment1.class);
//                                        startActivity(intent);
//                                    }
//                                }, 2000);
//
//                            }
//                        });
//
//                    }
//
//                }
//            });
//
//        }else {
//            Toast.makeText(this,"isi dulu ya", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//}
