package com.zhangfb95.plugins.mdp.file;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author zhangfb
 */
public class MdpFileTypeFactory extends FileTypeFactory {

    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        String extensions = "md" + FileTypeConsumer.EXTENSION_DELIMITER + "markdown";
        consumer.consume(MdpFileType.INSTANCE, extensions);
    }
}
