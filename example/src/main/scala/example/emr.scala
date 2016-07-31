
package example

import sys.process._
import scala.util.parsing.json._

/**
 * @author haxia
 */

object emr {

  def createEMRCluster() {
    val applications = "Name=Hadoop Name=Hive Name=Pig Name=Hue Name=Spark Name=Mahout"
    val tags = "name=demo_cluster"
    val ec2Attributes = """'{"KeyName":"takeda-demo","InstanceProfile":"EMR_EC2_DefaultRole","SubnetId":"subnet-24dbb840","EmrManagedSlaveSecurityGroup":"sg-ddfb69bb","EmrManagedMasterSecurityGroup":"sg-ddfb69bb"}'"""
    val serviceRole = "EMR_DefaultRole"
    val releaseLabel = "emr-4.7.1"
    val logURI = "'s3n://aws-logs-412275797347-us-west-2/elasticmapreduce/'"
    val name = "demo_cluster"
    val instanceGroups = "'[{\"InstanceCount\":2,\"InstanceGroupType\":\"CORE\",\"InstanceType\":\"m1.medium\",\"Name\":\"Core1\"},{\"InstanceCount\":1,\"InstanceGroupType\":\"MASTER\",\"InstanceType\":\"m1.medium\",\"Name\":\"Master1\"}]' "
    val region = "us-west-2"

    //    val emrCommand = s"aws emr create-cluster --applications $applications --tags $tags --ec2-attributes $ec2Attributes --service-role $serviceRole --enable-debugging --release-label $releaseLabel --log-uri $logURI --name $name --instance-groups $instanceGroups --region $region"
    val emrCommand = s"aws emr create-cluster --applications $applications --tags $tags --ec2-attributes $ec2Attributes --service-role $serviceRole --release-label $releaseLabel --log-uri $logURI --name $name --instance-groups $instanceGroups --region $region"

        println(emrCommand)

        val r = Process(emrCommand) !
    //    println("Return code: " + r)

  }

  def main(args: Array[String]): Unit = {

    createEMRCluster()
  }

}