package org.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Administrator
 * @className ILonginService
 * @description 肤痔清软膏 冰霜  艾洛松  达克宁或3%的硼酸 邦德阴虱清
 * 常用的有赛庚啶2mg,每日3次；扑尔敏4mg,每日3次；克敏嗪25mg,每日3次；息斯敏10mg,每日1次.外用药主要是皮质类固醇激素软膏,如去炎松软膏,肤乐软膏,尤卓尔软膏等.
 * @date {DATE}{TIME}
 */
@Path("/rest")
public interface ILoginService {
    @GET
    @Path("/login")
    String login(String name, String password);
}
