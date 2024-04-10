import {MessageInput, MessageList, MessageListItem} from "@vaadin/react-components";
import {useSignal} from "@vaadin/hilla-react-signals";
import { ChatService } from "Frontend/generated/endpoints";

export default function Chat() {
  const messages = useSignal<MessageListItem[]>([]);

  async function sendMessage(text: string) {
    messages.value = [...messages.value, {userName: 'You', text}];


    let first = true;
    ChatService.getStreamingCompletion(text).onNext(chunk => {
      if(first && chunk) {
        first = false;
        messages.value = [...messages.value, {userName: 'Bot', text: chunk}];
      } else {
        // append the chunk to the last message
        const last = messages.value.pop();
        if(last) {
          messages.value = [...messages.value, {userName: last.userName, text: last.text + chunk}];
      }}
    });
  }

  return (
    <div className="p-m flex flex-col h-full box-border">
      <MessageList className="flex-grow" items={messages.value} />
      <MessageInput onSubmit={e => sendMessage(e.detail.value)}/>
    </div>
  );
}