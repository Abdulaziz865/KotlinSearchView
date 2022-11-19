package com.example.practice

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.FragmentFirstBinding
import java.util.*

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var list: ArrayList<ModelList?>? = null
    private var listArray: ArrayList<ModelList?>? = null

    //    private var model: RecyclerModel? = null
    private val recyclerAdapter = RecyclerAdapter(listArray)
    private var rvListOfName: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = RecyclerAdapter(list)
        var layoutManager= GridLayoutManager(this.context,2)
        list?.add(ModelList("Adam"))
        list?.add(ModelList("Poul"))
        list?.add(ModelList("Fill"))
        list?.add(ModelList("Rex"))
        list?.add(ModelList("Hero"))
        list?.add(ModelList("Kit"))
        list?.add(ModelList("Val"))
        list?.add(ModelList("Joker"))
        list?.add(ModelList("Ben"))
        list?.add(ModelList("Size"))
        rvListOfName?.layoutManager = layoutManager
        rvListOfName?.adapter = myAdapter
        myAdapter.setData(list)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list, menu)
        val menuItem = menu.findItem(R.id.actionSearch)
        val searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText!!.isNotEmpty()) {
                    list?.clear()
                    val search = newText.lowercase(Locale.getDefault())
                    listArray?.forEach {
                        if (it?.name?.lowercase(Locale.getDefault())!!.contains(search)) {
                            list?.add(it)
                        }
                    }

                    rvListOfName?.adapter?.notifyDataSetChanged()

                } else {
                    list?.clear()
                    listArray?.let { list?.addAll(it) }
                    rvListOfName?.adapter?.notifyDataSetChanged()
                }
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}

