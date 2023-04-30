package com.example.famtrac

import android.os.Bundle
<<<<<<< Updated upstream
import androidx.fragment.app.Fragment
=======
import android.provider.ContactsContract
import android.util.Log
>>>>>>> Stashed changes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
<<<<<<< Updated upstream

class HomeFragment : Fragment() {

=======
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {

    lateinit var inviteAdapter : InviteAdapter

    private val listContacts:ArrayList<ContactModel> = ArrayList()

>>>>>>> Stashed changes
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMembers = listOf(
            MemberModel("Tarun", "C-211 Noida", "79", "223M"),
            MemberModel("kaushik", "Sector 3, Rohini, Delhi", "82", "42KM"),
            MemberModel("NFSU","NFSU, DC,New Delhi","88","21.81KM"),
            MemberModel("Papa", "1247, Bhagirathi, Ghaziabad","93","2.67KM"),
            MemberModel("Mummy","DAE Township, Kalpakkam, Chennai", "99","1098KM")
        )

        val adapter = MemberAdapter(listMembers)
        val recycler = requireView().findViewById<RecyclerView>(R.id.recycler_member)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
<<<<<<< Updated upstream

    }

=======

        inviteAdapter = InviteAdapter(listContacts)

        fun fetchDatabaseContacts() {
            val database = MyFamilyDatabase.getDatabase(requireContext())
             database.contactDao().getAllContacts().observe(viewLifecycleOwner){
                 listContacts.clear()
                 listContacts.addAll(it)

                 inviteAdapter.notifyDataSetChanged()
             }
        }

        suspend fun insertDatabaseContacts(listContacts: ArrayList<ContactModel>) {

            val database = MyFamilyDatabase.getDatabase(requireContext())

            database.contactDao().insertAll(listContacts)

        }

        inviteAdapter = InviteAdapter(listContacts)
        fetchDatabaseContacts()

        var inviteAdapter = InviteAdapter(listContacts)
        CoroutineScope(Dispatchers.IO).launch{


            insertDatabaseContacts(fetchContacts())
        }

        val inviteRecycler = requireView().findViewById<RecyclerView>(R.id.recycler_invite)
        inviteRecycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        inviteRecycler.adapter = inviteAdapter
        inviteAdapter = InviteAdapter(listContacts)

    }




    @SuppressLint("Range")
    private fun fetchContacts(): ArrayList<ContactModel> {

        Log.d("FetchContact89","fetchContacts: start")

        val cr = requireActivity().contentResolver
        val cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)

        val listContacts: ArrayList<ContactModel> = ArrayList()


        if (cursor != null && cursor.count > 0) {

            while (cursor != null && cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val hasPhoneNumber = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))

                if (hasPhoneNumber > 0) {

                    val pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        arrayOf(id),
                        ""
                    )

                    if (pCur != null && pCur.count > 0) {

                        while (pCur != null && pCur.moveToNext()) {

                            val phoneNum = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                            listContacts.add(ContactModel(name, phoneNum))

                        }
                        pCur.close()

                    }

                }
            }

            if (cursor != null) {
                cursor.close()
            }

        }
        Log.d("FetchContact89", "fetchContacts: end")
        return listContacts

    }


>>>>>>> Stashed changes
    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()


    }
}
