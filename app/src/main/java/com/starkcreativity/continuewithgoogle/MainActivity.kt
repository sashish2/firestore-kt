package com.starkcreativity.continuewithgoogle

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize firebase firestore
        val db = Firebase.firestore

        // Create a new user
        val user = hashMapOf(
            "first" to "Tony",
            "last" to "Stark",
            "born" to 2003
        )

        // Add a new document with a generated ID
        db.collection("users").add(user).addOnSuccessListener { documentReference ->
            Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
        }.addOnFailureListener{e -> Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()}




        // Create a new user with a first, middle, and last name
        val user2 = hashMapOf(
            "first" to "Alan",
            "middle" to "Mathison",
            "last" to "Turing",
            "born" to 1912
        )

        // Add a new document with a generated ID
        db.collection("users")
            .add(user2)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(applicationContext, "DocumentSnapshot added with ID: ${documentReference.id}", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(applicationContext, "Failed sec ", Toast.LENGTH_LONG).show()
            }


        // Read data
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for(document in result){
                    Toast.makeText(applicationContext, "${document.id} => ${document.data}", Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener{exception ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
            }


    }
}