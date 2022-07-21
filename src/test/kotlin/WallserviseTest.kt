import org.junit.Assert.*
import org.junit.Test

class WallserviseTest {
    @Test
    fun add() {
        val post = Post(id = 0)
        val expected = 4
        Wallservise.add(post)
        val result = Wallservise.add(post).id

        assertEquals(expected, result)
    }

    @Test
    fun update_true() {
        val post1 = Post(id = 11)
        val post2 = Post(id = 1, text = "newText")
        Wallservise.add(post1)

        val result = Wallservise.update(post2)

        assertTrue(result)
    }

    @Test
    fun update_false() {
        val post1 = Post(id = 11)
        val post2 = Post(id = 2, text = "newText")
        Wallservise.add(post1)

        val result = Wallservise.update(post2)

        assertFalse(result)
    }
    @Test
    fun shouldAddComment() {
        val postComment = Post(1)
        val commentTest1 = Comment(10, text = "Test")
        val expected = "Test"

        Wallservise.add(postComment)
        Wallservise.createComment(1, commentTest1)

        val result = commentTest1.text

        assertEquals(expected, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val commentTest2 = Comment(101, text = "Test" )
        Wallservise.createComment(10, commentTest2)
    }
}