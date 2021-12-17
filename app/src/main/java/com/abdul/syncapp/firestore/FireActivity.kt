package com.abdul.syncapp.firestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.abdul.syncapp.R
import com.google.firebase.firestore.FirebaseFirestore
import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnFailureListener

import com.google.firebase.firestore.DocumentReference

import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.QueryDocumentSnapshot

import com.google.firebase.firestore.QuerySnapshot

import com.google.android.gms.tasks.OnCompleteListener







class FireActivity : AppCompatActivity() {
    var TAG = FireActivity::class.java.simpleName

    lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire)
         db = FirebaseFirestore.getInstance();
    }

    fun firestoreHandler(view: android.view.View) {
        when(view.id){
            R.id.btnSend -> { sendDataFirestore()}
            R.id.btnRead -> { getDataFireStore()}
        }
    }

    private fun getDataFireStore() {
        db.collection("users")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            Log.d(TAG, document.id + " => " + document.data)
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.exception)
                    }
                }
    }

    private fun sendDataFirestore() {
        val user: MutableMap<String, Any> = HashMap()
        user["first"] = "Ada"
        user["last"] = "Lovelace"
        user["born"] = 1815

// Add a new document with a generated ID

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(OnSuccessListener<DocumentReference> {
                    documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.id)
                })
                .addOnFailureListener(OnFailureListener {
                    e -> Log.w(TAG, "Error adding document", e)
                })
    }
}