
import com.gabhendm.maelstrom.Node
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.util.Scanner
import kotlin.test.assertEquals


class NodeTest {

    @Test
    fun testParseMessage() {
        val `in` = ByteArrayInputStream("{\"dest\":\"n1\",\"body\":{\"type\":\"init\",\"node_id\":\"n1\",\"node_ids\":[\"n1\"],\"msg_id\":1},\"src\":\"c1\"}".toByteArray())
        System.setIn(`in`)
        val sc = Scanner(System.`in`)
        val node = Node("test", sc)
        val parsedObj = node.parseMessage(`in`);
        assertEquals("n1", parsedObj.dest)
        assertEquals("c1", parsedObj.src)
    }
}


