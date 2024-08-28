package com.example.contactsapp


object DataSource {
    fun getContactList(): List<Contact> {
        val contacts = mutableListOf<Contact>()

        contacts.add(
            Contact(
                R.drawable.auntie,
                "Auntie",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.brother,
                "Brother",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.daughter,
                "Daughter",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.friend_1,
                "Friend_1",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.friend_2,
                "Friend_2",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.grandfather,
                "Grandfather",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.granny,
                "Granny",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.neigbour,
                "Neigbour",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.sister,
                "Sister",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.son,
                "Son",
                "+20102345678"
            )
        )

        contacts.add(
            Contact(
                R.drawable.uncle,
                "Uncle",
                "+20102345678"
            )
        )
        return contacts
    }

}