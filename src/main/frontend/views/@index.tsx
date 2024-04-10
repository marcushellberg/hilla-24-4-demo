import {ContactService} from "Frontend/generated/endpoints";
import {AutoCrud} from "@vaadin/hilla-react-crud";
import ContactModel from "Frontend/generated/com/example/hillademo/ContactModel";

export default function Index() {

  return (
    <AutoCrud service={ContactService} model={ContactModel}/>
  );
}