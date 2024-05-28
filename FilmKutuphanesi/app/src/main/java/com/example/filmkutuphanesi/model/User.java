package com.example.filmkutuphanesi.model;

public class User {


        public String name;
        public String surname;
        public String email;

        public User() {
            // Varsayılan constructor, Firebase için gereklidir.
        }

        public User(String name,String surname, String email) {
            this.name = name;
            this.surname = surname;
            this.email = email;
        }
    }


