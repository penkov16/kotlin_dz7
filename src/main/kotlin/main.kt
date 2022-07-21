import java.util.Objects

fun main() {
    val post = Post(1)
    Wallservise.add(post)

    val comment = Comment(1, text = "Коммент")
    Wallservise.createComment(1, comment)
    println(comment.text)

}

data class Post(
    val id: Int? = null,
    val ownerId: Int? = null,
    val fromId: Int? = null,
    val createdBy: Int? = null,
    val date: Int? = null,
    val text: String? = null,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean? = null,
    val comments: Objects? = null,
    val copyright: Objects? = null,
    val likes: Objects? = null,
    val reposts: Objects? = null,
    val views: Objects? = null,
    val postType: String? = null,
    val post_source: Objects? = null,
    val attachment: Array<Attachment>? = null,
    val geo: Objects? = null,
    val signerId: Int? = null,
    val copy_history: Array<Post>? = null,
    val canPin: Boolean? = null,
    val canDelete: Boolean? = null,
    val canEdit: Boolean? = null,
    val isPinned: Boolean? = null,
    val markedAsAds: Boolean? = null,
    val isFavorite: Boolean? = null,
    val donut: Objects? = null,
    val postponedId: Int? = null
)
object Wallservise {
    private var posts = emptyArray<Post>()
    private var postid: Int = 1
    private var comments = emptyArray<Comment>()


    fun add(post: Post):Post{
        posts += post.copy(id = postid)
        postid++
        return posts.last()
    }
    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.id == post.id) {
                posts[index] = post.copy(id = post.id, date = post.date)
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment): Comment{
        for (post in posts){
            if(post.id == postId){
                comments += comment
                return comments.last()
            }

        }
        throw PostNotFoundException("Такой пост не найден")
    }
}

