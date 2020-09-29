package com.example.aicarapplication.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.aicarapplication.R;
import com.example.aicarapplication.adapter.ContentRecycleViewAdapter;
import com.example.aicarapplication.adapter.ItemRecycleViewAdapter;
import com.example.aicarapplication.pojo.ContentBean;
import com.example.aicarapplication.pojo.ItemBean;
import com.example.aicarapplication.pojo.NewsBean;

import java.util.ArrayList;
import java.util.List;

public class IndexFragment extends Fragment{
    private static IndexFragment instance = null;
    private RecyclerView recycleView_item,recyclerView_content;
    private LinearLayoutManager manager;
    private String[] titles=new String[]{"团队介绍","加入我们","更多资讯"};
    private int[] bgColor = new int[]{R.mipmap.team, R.mipmap.join, R.mipmap.info};
    private int[] newsImage=new int[]{R.drawable.img2,R.drawable.img1,R.drawable.img3,R.drawable.img4};
    private String[] newsTitle=new String[]{"秋冬流感季来袭 疾控专家十问十答支招防流感","我们改如何防治狂犬病？", "“防护18问”，为假期健康保驾护航"
    ,"秋季传染病蠢蠢欲动,请做好这些预防! "};
    private String[] newContent=new String[]{"新华网上海9月28日电（记者 仇逸）今年国庆中秋“双节”同过，面对即将来临的假期，许多市民都早早做好了休闲计划。目前正处于新冠肺炎疫情常态化防控阶段，“外防输入、内防反弹”的防控压力仍然存在。同时，夏秋之交的季节特点，既面临着新冠肺炎疫情与常见呼吸道传染病叠加流行的风险，又存在登革热、食源性疾病等威胁，因此，不管外出旅行、聚会还是居家休息，都要做到放假、防护两不误。上海市健康促进中心为市民送上“防护18问”，为假期健康保驾护航。\n" +
            "\n" +
            "　　    1、“十一”长假可以外出旅行吗？\n" +
            "\n" +
            "　　    答：当前仍处于新冠肺炎疫情全球大流行时期，尽量避免非必要的跨境旅行；如条件许可，可正常安排国内旅行，但要严格服从旅行目的地新冠防控工作的有关要求。\n" +
            "\n" +
            "　　    2、出行乘坐公共交通工具有哪些注意事项？\n" +
            "\n" +
            "　　    答：乘坐飞机、火车等公共交通工具时要全程佩戴口罩，并配合、遵守交通部门采取的各项防控措施和要求；尽量少触碰公共物品，勤洗双手，也可使用免洗手消毒剂保持手卫生。\n" +
            "\n" +
            "　　    3、去景点游玩应如何做到科学防护？\n" +
            "\n" +
            "　　    答：提早了解景区限流、预约等资讯，准备好健康码；尽量选择线上购票、扫码支付等非接触购票和支付方式；游玩时应勤洗手，不用脏手触摸眼口鼻；随身携带口罩，在相对封闭的空间和人员密集场所自觉佩戴；注意与他人保持1米以上的距离。\n" +
            "\n" +
            "　　    4、若在旅行中出现发热、咳嗽等不适症状，该如何处理？\n" +
            "\n" +
            "　　    答：如旅途过程中出现发热、咳嗽等不适症状，应立即佩戴口罩并尽量避免乘坐公共交通工具，及时到就近的医疗机构发热门诊就诊。\n" +
            "\n" +
            "　　    5、旅行归来后，还需要注意什么吗？\n" +
            "\n" +
            "　　    答：保存好各类行程票据和电子消费记录以备查询、追溯；回沪后做好个人健康监测，自主健康观察时间为14天；期间一旦出现发热、咳嗽等不适症状，应及时至附近医疗机构发热门诊就医并主动告知医生自己的旅行史。\n" +
            "\n" +
            "　　    6、参加聚餐聚会需要注意哪些细节？\n" +
            "\n" +
            "　　    答：牢记个人卫生，勤洗双手；注意保持社交距离，避免大声喧哗；就餐时使用公筷、公勺；避免暴饮暴食，做到饮食有度；如有发热、咳嗽等症状应避免参加聚集性活动。\n" +
            "\n" +
            "　　    7、在餐厅用餐，需采取哪些防护措施？\n" +
            "\n" +
            "　　    答：选择间距较大、通风较好的位置落座；二人以上合餐时应使用公筷公勺；建议采用非接触式的电子化支付方式。\n" +
            "\n" +
            "　　    8、趁着假期想来一次卫生大扫除需要注意哪些细节？\n" +
            "\n" +
            "　　    答：清理室内外各种杂物，清除各种积水和积水容器；检查地漏，确保存水弯功能正常；换洗晾晒被褥和枕头等；门把手、开关、遥控器等常用物品可用75%酒精棉球或消毒湿巾进行擦拭消毒。"+" 9、居家时多久需要开窗通风一次？\n" +
            "\n" +
            "　　    答：开窗通风是降低新冠肺炎等呼吸道传染病感染风险的有效手段之一。温度适宜或条件允许时可保持开窗通风，建议每天至少开窗通风2次，每次30分钟以上；通风时可打开家中距离最远的窗户或门，让流动的空气穿过整个房间，确保室内外空气充分流通和交换。\n" +
            "\n" +
            "　　    10、十月份的天气，还需要防范登革热吗？\n" +
            "\n" +
            "　　    登革热是由登革病毒引起，主要经伊蚊叮咬传播的一种以发热、皮疹、全身关节疼痛为主要症状的急性传染病，通常在夏秋季高发。目前仍处于登革热的易发季节，若去东南亚等热带、亚热带地区旅行更要引起重视，做好预防蚊虫叮咬措施。","今天是第14个“世界狂犬病日”。\n" +
            "\n" +
            "狂犬病，是迄今为止人类唯一病死率高达100%的急性传染病。\n" +
            "\n" +
            "世界卫生组织数据显示，狂犬病在全球150个国家流行，除南极洲以外，其他各州都存在狂犬病，但95%以上的人类死亡病例发生在亚洲和非洲以上的人类死亡病例发生在亚洲和非洲。\n" +
            "\n" +
            "据估计，每年狂犬病会导致全球5.9万人死亡，相当于每9分钟世界上就有1人死于狂犬病。而每例人患狂犬病病例背后，约170只犬也因此丧生。\n" +
            "\n" +
            "那么，狂犬病病毒只有狗才能传播吗？什么情况下需要接种狂犬病疫苗？日常生活中，如何预防狂犬病？\n" +
            "需要加强监测，准确和及时地诊断和适当地报告。\n" +
            "\n" +
            "WHO建议对处理感染或疑似感染材料的所有工作人员进行预防性免疫。\n" +
            "\n" +
            "暴露前预防接种程序包括第0、7天的两次注射。建议高危人群每1－3年加强接种1针。\n" +
            "\n" +
            "在欧洲的野生动物狂犬病控制项目中，SAG 2、SAD Bern、SAD B19等狂犬病毒株被用于口服疫苗免疫。\n" +
            "\n" +
            "暴露后预防(PEP)包括清洗伤口、及时按适当程序接种4支疫苗，必要时还应同时在伤口周围注射人源或马源抗狂犬病免疫球蛋白。\n" +
            "\n" +
            "以前累计接种过2支或以上疫苗者，无论过了多少年，再次暴露后只需在0、3天共接种2针加强针，终生不要再接种狂犬病免疫球蛋白。\n" +
            "\n" +
            "　　　接种狂犬病疫苗后的保护期\n" +
            "\n" +
            "　　　可细分为绝对保护期、有效保护期和相对保护期。\n" +
            "\n" +
            "1）　绝对保护期的规定相对保守：暴露后全程接种疫苗（PEP）后的3个月，或加强接种后的半年为绝对保护期。在此保护期内，再次暴露（无论多么严重）后都不需要再接种疫苗。\n" +
            "\n" +
            "2）　相对保护期为无限长：只要以前进行过暴露前或暴露后疫苗接种，即累计接种过２针（或以上，其中至少２针间隔７天或更久）疫苗，对于非咬伤类型的轻微暴露，均可不进行加强接种；对于超出轻微程度的暴露，无论过了多久，都只需加强接种１－2针（终生不需要再接种免疫球蛋白）。\n" +
            "\n" +
            "3）有效保护期相对固定：可认定暴露前或暴露后全程接种完疫苗（２针或２针以上，其中至少２针间隔７天或更久）后有效保护期为半年－1年，加强免疫后为1－3年。在此期间，对于不是特别严重的一般性暴露，都不必进行加强接种（有效保护期属于相对保护期的第一阶段）。\n" +
            "\n" +
            "接种疫苗后的风险评估\n" +
            "\n" +
            "迄今为止，在中和抗体浓度达到或高于0.5 IU/ml 的个体中，从未报告过狂犬病病例。 \n" +
            "\n" +
            "健康个体在完成了WHO推荐的免疫接种程序后，抗体滴度高于这个最低值的实际上达到了100％。  \n" +
            "\n" +
            "暴露后接种狂犬病疫苗越早效果越好。但万一耽搁了也不要过于担心。有大量病例证明，在病毒暴露发生几天甚至几个月后才进行处治也可能有效。 狂犬病毒一旦进入神经元，则它仍有潜在的可能被中和，虽然早期研究认为这种可能性较低。\n" +
            "\n" +
            "某些延迟接种疫苗却仍然有效的病例间接证明：狂犬病毒的抗体不仅能中和外周神经细胞内的病毒，在一定条件下也可能彻底清除CNS中的病毒。\n" +
            "\n" +
            "  　　发病前检测到足够高的抗体，就可肯定不会再发病。发病前检测到足够高的抗体，就证明其大脑功能尚未受损，至少是未严重受损，体内（包括CNS内）就不可能再有狂犬病病毒潜伏，就不会再发病。\n" +
            "\n" +
            "　　　避免狂犬病疫苗的滥用。\n" +
            "\n" +
            "　　　70年来，中国的人狂犬病有3个流行高峰和3个低谷。每年死亡人数的最大波动幅度在7,037人（1981年）和159人（1996年）之间。\n" +
            "\n" +
            "　　人狂犬病年度死亡人数的这种波动与狗群数量的波动密切相关（在其他国家，通常还与狗的疫苗接种比例有关），也与狂犬病毒自身的消长和流行规律有关，而与人群疫苗接种量关系不大（疫苗对当年人群死亡率的影响不超过30%）。\n" +
            "\n" +
            "　　　如果完全不进行暴露后预防，我国每年狂犬病死亡人数的上限是1万人。\n" +
            "\n" +
            "　　　中国的狂犬病疫苗使用量按每年1,500万人份计算，实际上至多只有1,500分之一用在了真正需要的人身上，即接种了疫苗的人当中有99.9%以上本来都是可以不接种狂犬病疫苗的。所以，非常有必要进行狂犬病风险的定量评估和防治的成本/效益分析。\n" +
            "\n" +
            "十日观察法\n" +
            "\n" +
            "“如果动物（主要指狗和猫）在10天的观察期内，仍然保持健康，或经可靠的实验室使用正确的诊断技术证实动物为狂犬病阴性，则可以终止处治（不再接种疫苗）。”（WHO）","当前，境外新冠肺炎疫情持续扩散蔓延，秋冬季新冠肺炎疫情流行的风险较高，同时流感等其他呼吸道传染病进入流行季。如何在常态化疫情防控形势下科学预防流感?9月28日下午，四川省疾病预防控制中心免规所所长、主任医师漆琪就这些问题进行了解答。\n" +
            "\n" +
            "　　1.流感是什么？主要传染源有哪些？流感的传播有哪些？哪些人容易患流感？\n" +
            "\n" +
            "　　答：流感是由流感病毒引起的一种急性呼吸道传染病。流感病毒因其抗原性易变，传播迅速，每年在冬春季可引起季节性流行，在学校、托幼机构和养老院等人群聚集的场所可发生暴发疫情。流感病毒可分为甲、乙、丙、丁四型。只有甲型、乙型和丙型流感病毒会感染人。目前，引起流感季节性流行的病毒是甲型中的H1N1、H3N2亚型及乙型病毒的Victoria和Yamagata系。\n" +
            "\n" +
            "　　患者和隐性感染者是主要传染源。从潜伏期末到急性期都有传染性，病毒在人呼吸道分泌物中一般持续排毒 3～7 天，儿童、免疫功能受损及危重患者排毒时间可超过 1周。\n" +
            "\n" +
            "　　流感病毒主要通过打喷嚏和咳嗽等飞沫传播，经口腔、鼻腔、眼睛等黏膜直接或间接接触感染。接触被病毒污染的物品也可通过上述途径感染。在特定场所，如人群密集且密闭或通风不良的房间内，也可能通过气溶胶的形式传播，需引起警惕。\n" +
            "\n" +
            "　　人群普遍易感。一些高危人群如60岁及以上的居家老年人、6月龄-5岁儿童、慢性病患者、6月龄以下婴儿的家庭成员和看护人员、以及孕妇患流感后易出现重症和死亡，需高度重视。\n" +
            "\n" +
            "　　2.得了流感有哪些症状？和普通感冒有哪些区别？\n" +
            "\n" +
            "　　答：流感一般表现为急性起病、发热（可达39-40摄氏度），伴畏寒、寒战、头痛、肌肉关节酸痛、极度乏力、食欲减退等全身症状，常有咽痛、咳嗽，可有鼻塞、流涕、胸骨后不适、颜面潮红、粘膜轻度出血，也可有呕吐、腹泻等症状。轻症流感常与普通感冒表现相似，但其发热和全身症状更明显。重症病例可出现病毒性肺炎、继发细菌性肺炎、急性呼吸窘迫综合征、休克、弥漫性血管内凝血、心血管和神经系统等肺外表现及多种并发症。\n" +
            "\n" +
            "　　流感和普通感冒的区别：\n" +
            "\n" +
            "　　①病毒不同。流感是特指由流感病毒各型引起的呼吸道感染；普通感冒是指由各种的病原体引起的咽喉部及上呼吸道感染，如鼻病毒、冠状病毒、细菌等。 ②流行性不同。流感常能引起不同程度的流行，传染性强，有明显季节性；而普通感冒多为散发，传染性弱，季节性不明显。③ 临床症状不同。流感的临床症状比普通感冒严重，流感主要是全身症状重，多高热（39～40°C），可伴寒颤；而普通感冒主要是呼吸道局部症状比较明显，不发热或轻、中度热,无寒颤。流感不仅可以引起病毒性肺炎，还能并发细菌性肺炎、中耳炎、心肌炎等并发症。通常来说，流感临床表现缺乏特异性，流感确诊有赖于实验室诊断，目前临床上应用检测方法主要为流感病毒核酸检测和快速抗原检测。"
    ,"秋冬是诺如病毒的高发期，尤其是在相对封闭的环境，如学校、餐馆、医院等地。\n" +
            "\n" +
            "　　虽然目前诺如病毒急性肠胃炎没有特效药，以补剂及对症治疗为主，但也不必过于紧张，因为它为自限性疾病，病情轻微，愈后良好，恢复后无后遗症。\n" +
            "\n" +
            "　　面对诺如病毒的时候，其实预防比治疗更重要！\n" +
            "\n" +
            "　　①注意个人卫生，养成良好的卫生习惯，勤洗手，饭前便后要洗手；\n" +
            "\n" +
            "　　②注意饮食和饮水卫生，喝开水、吃熟食，不食不洁、无证食品；\n" +
            "\n" +
            "　　③在秋冬季腹泻高发期尽量少去人多的公共场所，保持室内良好的空气流通，每日开窗通风不少于2次，每次不少于30分钟，减少病毒感染的机会；\n" +
            "\n" +
            "　　④多吃新鲜蔬果，多元化饮食；增强锻炼，改善体质；\n" +
            "\n" +
            "　　除了“诺如病毒”\n" +
            "\n" +
            "　　这五种传染病也要警惕！\n" +
            "\n" +
            "　　1 ●\n" +
            "\n" +
            "　　流行性腮腺炎\n" +
            "\n" +
            "　　流行性腮腺炎简称流腮，俗称痄腮，是由腮腺炎病毒引起的急性呼吸道传染病。好发年龄为5-15岁，四季均有流行。\n" +
            "\n" +
            "　　主要表现为腮腺肿痛，肿痛具有特征性，一般以耳垂为中心，状如梨形或马蹄形，边缘不清，有触痛，张口、咀嚼时刺激唾液分泌，导致疼痛加剧。部分患儿可伴有发热、咽痛、全身不适等表现，部分患儿常伴有并发症。\n" +
            "\n" +
            "　　患者是传染源，通过直接接触、飞沫、唾液的吸入传播，接触患者2-3周发病。\n" +
            "\n" +
            "　　预防建议\n" +
            "\n" +
            "　　①房间开窗通风很重要。\n" +
            "\n" +
            "　　②早期隔离患者至腮腺肿胀完全消退，且病程至少达9天后才能上学。接触过腮腺炎患者需要密切观察3周。\n" +
            "\n" +
            "　　③给予规范的腮腺炎减毒活疫苗或麻腮风三联疫苗接种，免疫成功率可达70-90%。\n" +
            "\n" +
            "　　2 ●\n" +
            "\n" +
            "　　流行性感冒\n" +
            "\n" +
            "　　流行性感冒是由流行性感冒病毒引起的急性呼吸道传染病，通过咳嗽、打喷嚏等空气飞沫方式传播。\n" +
            "\n" +
            "　　它表现为急性起病、发热( 可达39℃-40℃ )，伴有畏寒、寒战、头痛、肌肉酸痛、乏力、食欲减退等全身症状，接触患者1～7天发病。\n" +
            "\n" +
            "　　预防建议\n" +
            "\n" +
            "　　①流感患者应及时就诊治疗，隔离至体温正常后48小时才能复课。\n" +
            "\n" +
            "　　②室内应经常开窗通风，注意个人卫生，咳嗽、打喷嚏时应使用纸巾等，避免飞沫传播。经常彻底洗手，避免脏手接触口、眼、鼻。\n" +
            "\n" +
            "　　③适当参加运动锻炼，合理膳食和休息，增强体质。\n" +
            "\n" +
            "　　④预防流感最有效的方法是接种“流感”疫苗，每年流行季节前（9-12月）接种一次，免疫力可持续一年。\n" +
            "\n" +
            "　　3 ●\n" +
            "\n" +
            "　　腺病毒感染\n" +
            "\n" +
            "　　由腺病毒引起的急性传染病，易侵犯呼吸道及消化道黏膜、眼结膜、泌尿道和淋巴结。主要表现为急性上呼吸道感染（急性呼吸道感染由腺病毒引起者占2%～4%），其次为眼部和胃肠道感染。\n" +
            "\n" +
            "　　人群普遍易感，多见于儿童。约半数患者为隐性感染。接触患者和隐性感染者均可传染，接触患者3-7天发病。病毒由呼吸道和眼结膜分泌物、粪便及尿排出体外，经空气飞沫、密切接触及粪―口途径传播。\n" +
            "\n" +
            "　　预防建议\n" +
            "\n" +
            "　　①注意手卫生（饭前，便后用流动水洗手）、消毒、物品专用。\n" +
            "\n" +
            "　　②对于易感人群注意保护性隔离，做好个人防护，健康管理，避免过度劳累。\n" +
            "\n" +
            "　　4 ●\n" +
            "\n" +
            "　　水痘\n" +
            "\n" +
            "　　水痘是由水痘带状疱疹病毒初次感染引起的急性传染病。多见于儿童。\n" +
            "\n" +
            "　　以发热及皮肤和黏膜成批出现周身性红色斑丘疹、疱疹、痂疹为特征，皮疹呈向心性分布，主要发生在胸、腹、背，四肢很少，传染力极强。水痘患者是传染源，自发病前1～2天直至皮疹干燥结痂期均有传染性，可通过接触患者和空气飞沫传播。易感儿发病率可达95%以上。接触患者12-21天发病。"};
    public static IndexFragment getInstance() {
        if (instance == null) {
            instance = new IndexFragment();
        }
        return instance;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(new GuideFragment());

    }


    public IndexFragment() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index, container, false);
        Toolbar toolbar=view.findViewById(R.id.toolbar);
        getActivity().setActionBar(toolbar);
        // todo 主页菜单的RecycleView
        recycleView_item=view.findViewById(R.id.recycle_view_item);
        recycleView_item.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        List<ItemBean> itemBeans=new ArrayList<>();
        for(int i=0;i<titles.length;i++){
            ItemBean bean=new ItemBean();
            bean.setItemName(titles[i]);
            bean.setItemImage(bgColor[i]);
            itemBeans.add(bean);
        }
        ItemRecycleViewAdapter adapter=new ItemRecycleViewAdapter(getContext(),itemBeans);
        recycleView_item.setAdapter(adapter);
        // todo 主页菜单下的RecycleView
        recyclerView_content=view.findViewById(R.id.recycle_view_content_);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        recyclerView_content.setLayoutManager(manager);
        List<ContentBean> contentBeans=new ArrayList<>();
        List<NewsBean> newsBeans=new ArrayList<>();
        for(int i=0;i<newsTitle.length;i++){
            contentBeans.add(new ContentBean(newsTitle[i],newsImage[i],newContent[i]));
            NewsBean newsBean=new NewsBean(newsTitle[i],newContent[i],newsImage[i]);
            newsBeans.add(newsBean);
        }
        ContentRecycleViewAdapter contentRecycleViewAdapter=new ContentRecycleViewAdapter(getContext(),contentBeans,newsBeans);
        recyclerView_content.setAdapter(contentRecycleViewAdapter);
        return view;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getChildFragmentManager();//这里获取碎片管理器的方法不同于碎片中嵌套碎片这里使用的是getSupportFragmentManager（）  注：貌似这里亦可以用getFragmentManager（）
        FragmentTransaction transaction = fragmentManager.beginTransaction();//开启一个事物，通过调用beginTransaction（）开启
        transaction.replace(R.id.banner,fragment);//向容器内替换碎片（添加用.add）  第一个参数：容器id  第二个参数：待添加的碎片
        transaction.commit();//提交事务
    }
}
