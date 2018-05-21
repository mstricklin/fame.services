package com.ticomgeo.fame;

import com.ticomgeo.fame.descriptors.ServiceProviderDescriptor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author mstricklin
 * @version 1.0
 */
public class App {

    @SuppressWarnings("unused")
    private static final Logger CLASS_LOGGER = LoggerFactory.getLogger((new Throwable()).getStackTrace()[0].getClassName());

    @SuppressWarnings("unused")
    private static final String NEWLINE = System.getProperty("line.separator");

    public static void main(String[] args) {

        List<String> nodes = newArrayList(
                "com.ticomgeo.fame.providers.PeriodicEventProvider",
                "com.ticomgeo.fame.providers.PushPointEventProvider"
        );
        nodeDescriptions(nodes);

    }


    public static ServiceProviderDescriptor nodeDescriptions(Collection<String> nodeNames) {

        Collection<ServiceProviderDescriptor> providers = newArrayList();

        for (String nodeName: nodeNames) {
            try {
                Class<? extends FamePipelineNode> fpn = (Class<? extends FamePipelineNode>) Class.forName(nodeName);
                ProviderDescriptorTag pdt = fpn.getAnnotation(ProviderDescriptorTag.class);
                if (null != pdt) {
                    // I'm a provider
                    Class<? extends ServiceProviderDescriptor> spdClazz = pdt.descriptor();
                    ServiceProviderDescriptor spd = spdClazz.newInstance();
                    // dump spd
                    System.out.printf("Provider %s\n", nodeName);
                    System.out.printf("\t%s\n", spd);

                }
                if (null != fpn.getAnnotationsByType(ConsumerDescriptorTag.class)) {
                    // I'm a consumer
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}