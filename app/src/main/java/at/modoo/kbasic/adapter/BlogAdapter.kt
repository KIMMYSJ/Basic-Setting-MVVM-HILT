package at.modoo.kbasic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import at.modoo.kbasic.R
import at.modoo.kbasic.databinding.BlogRowBinding
import at.modoo.kbasic.model.Blog
import at.modoo.kbasic.utility.CustomDiffUtil
import com.bumptech.glide.Glide

class BlogAdapter(private var blogList: List<Blog>): RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    private lateinit var binding:BlogRowBinding




    //override fun
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        binding = BlogRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.blog_row,parent,false)
        return BlogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.blogRowBinding.blog = blogList[position]
        holder.blogRowBinding.executePendingBindings()
        holder.blogRowBinding.root.setOnClickListener {
            Toast.makeText(it.context, "position: $position" + "&title: ${blogList[position].title}",Toast.LENGTH_LONG).show()
        }
//        holder.blogRowBinding.blog = blogList[position]
//        holder.blogRowBinding.executePendingBindings()

    }

    override fun getItemCount(): Int {
       return blogList.size
//        return blogList.size
    }

    inner class BlogViewHolder(val blogRowBinding: BlogRowBinding) : RecyclerView.ViewHolder(blogRowBinding.root){

//        traditional way...
//        var imageView:ImageView = itemView.findViewById(R.id.iv_thumbnail)
//        var title:TextView = itemView.findViewById(R.id.tv_title)
//        var author:TextView = itemView.findViewById(R.id.tv_author)
//
//        fun bind(blog:Blog){
//            Glide.with(imageView).load(blog.thumbnail).into(imageView)
//            title.text = blog.title
//            author.text = blog.author
//        }
    }

    fun setData(newBlogList:List<Blog>){
        val diffUtil = CustomDiffUtil(blogList,newBlogList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        blogList = newBlogList
        diffResults.dispatchUpdatesTo(this)
    }



}