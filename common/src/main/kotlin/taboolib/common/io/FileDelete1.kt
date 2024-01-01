@file:Isolated

package taboolib.common.io

import taboolib.common.Isolated
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * 删除特定文件夹下的所有子文件
 */
fun File.deepDelete() {
    if (exists()) {
        if (isDirectory) {
            listFiles()?.forEach { it.deepDelete() }
        }
        delete()
    }
}

/**
 * 复制文件或文件夹
 * 若目标为文件夹则复制其所有子文件
 */
fun File.deepCopyTo(target: File) {
    if (isDirectory) {
        listFiles()?.forEach { it.deepCopyTo(File(target, it.name)) }
    } else {
        copyTo(target)
    }
}
