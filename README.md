CtProdSearchIndex
=================

nohup hadoop jar CtlgSearchIndex-1.0-SNAPSHOT-jar-with-dependencies.jar com.ebay.dss.job.SequenceFileDedup \
-D mapreduce.user.classpath.first=true -D yarn.app.mapreduce.am.resource.mb=4096 \
-D mapred.job.queue.name=hdmi-prod \
-in /sys/edw/ct_product_search_index/in/2010/12/01/00 \
-out /sys/edw/ct_product_search_index/sequence/2010/12/01/00 \
-process_date 20141015 \
-reduce_task 100 > ct_product_search_index_sequence.log &


nohup hadoop jar CtlgSearchIndex-1.0-SNAPSHOT-jar-with-dependencies.jar com.ebay.dss.job.CtlgSearchIndex \
-D mapreduce.user.classpath.first=true -D yarn.app.mapreduce.am.resource.mb=4096 \
-D mapred.job.queue.name=hdmi-prod \
-D mapred.reduce.tasks=20 \
-in /sys/edw/ct_product_search_index/sequence/2010/12/01/00 \
-out /sys/edw/ctlg_prod_srch_index_attr/sequence/2010/12/01/00 > ctlg_search_index.log &


nohup hadoop jar CtlgSearchIndex-1.0-SNAPSHOT-jar-with-dependencies.jar com.ebay.dss.job.ProdImageStatus \
-D mapreduce.user.classpath.first=true -D yarn.app.mapreduce.am.resource.mb=4096 \
-D mapred.job.queue.name=hdmi-prod \
-D mapred.reduce.tasks=50 \
-in /sys/edw/ct_product_search_index/snapshot/2014/12/14/00 \
-out /sys/edw/dw_ctlg_prod_img_sts_lkp_w/sequence/2010/12/14/00 > prod_image_status.log &


nohup hadoop jar CtlgSearchIndex-1.0-SNAPSHOT-jar-with-dependencies.jar com.ebay.dss.job.ProdPriceInfo \
-D mapreduce.user.classpath.first=true -D yarn.app.mapreduce.am.resource.mb=4096 \
-D mapred.job.queue.name=hdmi-prod \
-D mapred.reduce.tasks=50 \
-in /sys/edw/ct_product_search_index/snapshot/2014/12/14/00 \
-out /sys/edw/dw_ctlg_prod_pricing_info_w_i/sequence/2014/12/14/00 > prod_price_info.log &